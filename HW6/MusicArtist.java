import java.util.ArrayList;

/**
 * Homework 6-3: List artists and albums
 * @author Kuei-Lin Yang
 * Mar 6, 2018
 */
public class MusicArtist {
	// declare instance variables
	private String name = null;
	private ArrayList<String> albums = null;
	
	// constructor
	public MusicArtist() {
		name = new String();
		albums = new ArrayList<>();
	}
	
	protected void setName(String name) {
		this.name = name;
	}
	
	protected void setAlbums(String album) {
		albums.add(album);
	}
	
	protected String getName() {
		return name;
	}
	
	protected ArrayList<String> getAlbums(){
		return albums;
	}
	
}
