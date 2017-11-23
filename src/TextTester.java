import java.util.ArrayList;

/**
 * This is where I test all of the methods I wrote.
 * @author connorfairman
 *
 */
public class TextTester {

	public static void main(String[] args) {
		// Construct new TextReader objects for each version of the Analects that I'm working with
		TextReader analectsGiles = new TextReader("Analects(Giles).txt");
		TextReader analectsLegges1 = new TextReader("Analects(Legge).txt");
		TextReader analectsLegges2 = new TextReader("Analects(Legge2).txt");
		
		// Giles' Translation
		ArrayList<String> analects = analectsGiles.getLines();
		Analects giles = new Analects(analects);
		giles.getMasterCount();
		giles.getTheMasterSaid();
		
		// Legge's first translation
		ArrayList<String> analects1 = analectsLegges1.getLines();
		Analects legges1 = new Analects(analects1);
		legges1.getMasterCount();
		legges1.getTheMasterSaid();
		
		// Legge's second translation
		ArrayList<String> analects2 = analectsLegges2.getLines();
		Analects legges2 = new Analects(analects2);
		legges2.getMasterCount();
		legges2.getTheMasterSaid();


	}

}
