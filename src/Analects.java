import java.util.ArrayList;

/**
 * This is where I will have all of my methods for doing textual analysis of "the Analects".
 * @author connorfairman
 *
 */
public class Analects {
	
	private ArrayList<String> analects;
	
	/**
	 * Constructor. Takes in a specific version/edition of the Analects as an argument.
	 * @param Analects
	 */
	public Analects(ArrayList<String> analectsVersion) {
		this.analects = analectsVersion;
	}
	
	/**
	 * One word that persists throughout these books is the word "master", used to describe
	 * Confucius himself. Let's see how many times the word appears. I will then see the results 
	 * for each book when I run this in my tester class.
	 */
	public void getMasterCount() {
		int masterCount = 0;
		for (String line : analects) {
			String[] words = line.split("[^a-zA-Z]+");
			for (String currentWord : words) {
				if (currentWord.equals("master") || currentWord.equals("Master")) {
					masterCount++;
				}
			}
		}
		System.out.println("'master' or 'Master' appears " + masterCount + " times");
	}
	
	
	/**
	 * This method is for getting the number of times "the Master said" and "The Master said" appears.
	 */
	public void getTheMasterSaid() {
		int masterSaidCount = 0;
		for (String line : analects) {
			if (line.contains("The Master said") || line.contains("the Master said") || 
					line.contains("The master said" ) || line.contains("the master said")) {
				masterSaidCount++;
			}
		}
		System.out.println("'The/the M/master said appears: " + masterSaidCount + " times");
	}

}
