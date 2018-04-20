import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;


/**
 * A RunnerXmlFile class implements RunnerDAO interface
 * It reads an xml file and retrieve related runners' information in an array list
 * 
 * @author Kuei-Lin Yang
 * Mar 23, 2018
 */
public final class RunnerXmlFile implements RunnerDAO{
	/**
	 * Declare instance variables
	 */
	private ArrayList<Runner> runners;
	private String fileName;
	private File runnersFile;
	
	/**
	 * Constructor with one String parameter
	 * @param fileName	xml filename
	 */
	public RunnerXmlFile(String fileName) {
		runners = null;
		this.fileName = fileName;
		runnersFile = null;
	}
	
	/** 
	 * Define getRunners function
	 * @return ArrayList	runners in an array list
	 */
	public ArrayList<Runner> getRunners(){
		ClassLoader classLoader = getClass().getClassLoader();
		if(classLoader.getResource(fileName) == null) {
			return null;
		}
		else
			runnersFile = new File(classLoader.getResource(fileName).getFile());
		
		runners = new ArrayList<>();
		Runner r = null;
        if (runnersFile.exists())  // prevent the FileNotFoundException
        {
            // create the XMLInputFactory object
            XMLInputFactory inputFactory = XMLInputFactory.newFactory();
            try
            {
                // create a XMLStreamReader object
                FileReader fileReader =
                    new FileReader(runnersFile);
                XMLStreamReader reader =
                    inputFactory.createXMLStreamReader(fileReader);

                // read the products from the file
                while (reader.hasNext())
                {
                    int eventType = reader.getEventType();
                    switch (eventType)
                    {
                        case XMLStreamConstants.START_ELEMENT:
                            String elementName = reader.getLocalName();
                            if (elementName.equals("Runner"))
                            {
                                r = new Runner();
                                String name = reader.getAttributeValue(0);
                                r.setName(name);
                            }
                            if (elementName.equals("RunnersMoveIncrement"))
                            {
                                String speedText = reader.getElementText();
                                int speed = Integer.parseInt(speedText);
                                r.setSpeed(speed);
                            }
                            if (elementName.equals("RestPercentage"))
                            {
                                String restPercentageText = reader.getElementText();
                                int restPercentage = Integer.parseInt(restPercentageText);
                                r.setRestPercentage(restPercentage);
                            }
                            break;
                        case XMLStreamConstants.END_ELEMENT:
                            elementName = reader.getLocalName();
                            if (elementName.equals("Runner"))
                            {
                                runners.add(r);
                            }
                            break;
                        default:
                            break;
                    }
                    reader.next();
                }
            }
            catch (IOException | XMLStreamException e)
            {
                System.out.println(e);
                return null;
            }
        }
        return runners;  
	}
}
