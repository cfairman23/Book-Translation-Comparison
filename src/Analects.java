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
			String[] words = line.toLowerCase().split("[^a-zA-Z]+");
			for (String currentWord : words) {
				if (currentWord.equals("master")) {
					masterCount++;
				}
			}
		}
		System.out.println("'master' appears " + masterCount + " times");
	}
	
	
	/**
	 * This method is for getting the number of times "the Master said" and "The Master said" appears.
	 */
	public void getTheMasterSaid() {
		int upperCaseMasterSaidCount = 0;
		int lowerCaseMasterSaidCount = 0;
		for (String line : analects) {
			if (line.contains("The Master said")) {
				upperCaseMasterSaidCount = upperCaseMasterSaidCount + 1;
			}
			if (line.contains("the Master said")) {
				lowerCaseMasterSaidCount = lowerCaseMasterSaidCount + 1;
			}
		}
		System.out.println("'The Master said appears: " + upperCaseMasterSaidCount + " times");
		System.out.println("'the Master said appears: " + lowerCaseMasterSaidCount + " times");
	}

}
