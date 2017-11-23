import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Standard Text Reader class that reads in a file line-by-line and stores each line
 * in an ArrayList of Strings. 
 * @author connorfairman
 *
 */
public class TextReader {

	private String filename;
	private ArrayList<String> lines;

	/**
	 * Constructor	
	 * @param file the file to read
	 */
	public TextReader(String file) {
		filename = file;
		lines = new ArrayList<String>();
		readFile();
	}

	/**
	 * This will read in the entire text file.
	 * It will store the contents in the lines ArrayList
	 */
	private void readFile() {
		try {
			File inputFile = new File(filename); // creates appropriate object
			Scanner instream = new Scanner(inputFile);
			while(instream.hasNextLine()) {
				String line = instream.nextLine(); // gets a line from file
				lines.add(line);
			}
			instream.close();
		} catch (Exception e) {
			System.out.println("Your file couldn't be found");
			e.printStackTrace();
		}
	}
	public ArrayList<String> getLines() {
		return lines;
	}
}
