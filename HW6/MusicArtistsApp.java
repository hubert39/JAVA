import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

/**
 * Homework 6-3: List artists and albums
 * @author Kuei-Lin Yang
 * Mar 6, 2018
 */
public class MusicArtistsApp {
	private static String xmlFilename = "music_artists.xml";
	private static ArrayList<MusicArtist> artistsArray = null;
	
	// get values from xml file and save them to music object arraylist
	private static ArrayList<MusicArtist> getArtists(){
		XMLInputFactory inputFactory = XMLInputFactory.newFactory();
		try {
			ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
			FileReader fileReader = new FileReader(classLoader.getResource(xmlFilename).getFile());
			XMLStreamReader reader = inputFactory.createXMLStreamReader(fileReader);
			
			artistsArray = new ArrayList<>();
			MusicArtist musicArtist = null;
			while(reader.hasNext()) {
				int eventType = reader.getEventType();
				switch(eventType) {
					case XMLStreamConstants.START_ELEMENT:
						String elementName = reader.getLocalName();
						if(elementName.equals("Name")) {
							musicArtist = new MusicArtist();
							String name = reader.getElementText();
							musicArtist.setName(name);
						}else if(elementName.equals("Album")) {
							String album = reader.getElementText();
							musicArtist.setAlbums(album);
						}
						//System.out.println("START_ELEMENT:" + eventType + elementName);
						break;
					case XMLStreamConstants.END_ELEMENT:
						elementName = reader.getLocalName();
						if(elementName.equals("Artist")) {
							artistsArray.add(musicArtist);
						}
						//System.out.println("END_ELEMENT:" + eventType+ elementName);
						break;
					default:
						break;
				}
				reader.next();
			}
		}catch(IOException | XMLStreamException e) {
			System.out.println(e);
		}
		return artistsArray;
	}
	
	// display artists' name
	private static void displayArtists(ArrayList<MusicArtist> artistsArray) {
		System.out.println("Artists\n-------");
		for(MusicArtist musicArtist : artistsArray) {
			System.out.println(musicArtist.getName());
		}
		System.out.println();
	}
	
	// display artists' albums
	private static void displayAlbums(ArrayList<MusicArtist> artistsArray) {
		System.out.println("Albums\n------");
		for(MusicArtist musicArtist : artistsArray) {
			for(String album : musicArtist.getAlbums())
				System.out.println(album);
		}
		System.out.println();
	}
	
	// display artists' name and albums
	private static void displayArtistsAndAlbums(ArrayList<MusicArtist> artistsArray) {
		System.out.println("Artists and Albums\n------------------");
		for(MusicArtist musicArtist : artistsArray) {
			System.out.println(musicArtist.getName());
			for(String album : musicArtist.getAlbums())
				System.out.println("\t" + album);
		}
	}
	
	public static void main(String[] args) {
		System.out.println("Artist and Album Listing");
		System.out.println();
		
		artistsArray = getArtists();
		displayArtists(artistsArray);
		displayAlbums(artistsArray);
		displayArtistsAndAlbums(artistsArray);
	}

}
