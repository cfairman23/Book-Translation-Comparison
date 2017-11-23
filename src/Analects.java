import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

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
	
	/**
	 * This method gets the top 25 most common words in each version with the generic words contained
	 * in a stop-list filtered out. 
	 */
	public void getWords() throws FileNotFoundException {
		HashMap<String, Integer> wordMap = new HashMap<String, Integer>();
		for (String line : analects) {
			String[] words = line.toLowerCase().split("[^a-zA-Z]+");
			for (String currentWord : words) {
				if (wordMap.containsKey(currentWord)) {
					wordMap.put(currentWord, wordMap.get(currentWord) + 1);
				} else {
					wordMap.put(currentWord, 1);
				}
			}
		}
		wordMap.remove(""); // remove empty space as a word
		
		Scanner stopList = new Scanner (new File("stop-list.txt")).useDelimiter("[^a-zA-Z]+");
		HashMap<String, Integer> stopListMap = new HashMap<String, Integer>();
		while (stopList.hasNext()) {
			String word = stopList.next().toLowerCase();
			if (stopListMap.containsKey(word)) {
				stopListMap.put(word, stopListMap.get(word) + 1);
			} else {
				stopListMap.put(word, 1);
			}
		}
		Iterator<String> iterator = wordMap.keySet().iterator();
		while (iterator.hasNext()) {
			String key = iterator.next();
			if (stopListMap.containsKey(key)) {
				iterator.remove();
			}
		}
		for (int i = 1; i <= 25; i++) {
			int keyValue = 0;
			String frequentWord = null;
			for (String key : wordMap.keySet()) {
				if (wordMap.get(key) > keyValue) {
					keyValue = wordMap.get(key);
					frequentWord = key;
				}
			}
			System.out.println("Number" + " " + i + ":" + " " + frequentWord + " " + keyValue);
			wordMap.remove(frequentWord);
		}
		stopList.close();
	}
}
