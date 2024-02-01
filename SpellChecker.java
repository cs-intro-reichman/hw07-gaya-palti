import javax.swing.plaf.synth.SynthStyle;

public class SpellChecker {


	public static void main(String[] args) {
		String word = args[0];
		int threshold = Integer.parseInt(args[1]);
		String[] dictionary = readDictionary("dictionary.txt");
		String correction = spellChecker(word, threshold, dictionary);
		System.out.println(correction);
	}

	public static String tail(String str) {
		String newTail = "";
		if (str.length() == 1){
			newTail = "";
		} else {
			newTail = str.substring(1, str.length());
		}
		return newTail;
	}

	public static int levenshtein(String word1, String word2) {
		int levenValue = 0;
		word1 = word1.toLowerCase();
		word2 = word2.toLowerCase();		
		if (word1.length() == 0){
			levenValue = word2.length();
		} else if (word2.length() == 0) {
			levenValue = word1.length();
		} else if (word1.charAt(0) == word2.charAt(0)){
			levenValue = levenshtein(tail(word1), tail(word2));
		} else {
			int minLeven = Math.min(
								Math.min(
									levenshtein(tail(word1), word2), 
									levenshtein(word1, tail(word2))), 
							  	levenshtein(tail(word1), tail(word2)
								)
							);
			levenValue = 1 + minLeven;

		}

		return levenValue;
	}

	public static String[] readDictionary(String fileName) {
		String[] dictionary = new String[3000];
		In in = new In(fileName);
		for (int i = 0; i < dictionary.length; i++){
			dictionary [i] = in.readLine();
		}
		return dictionary;
	}

	public static String spellChecker(String word, int threshold, String[] dictionary) {
		String newWord = word;
		int minLevenValue = threshold + 1;
		int curLevenValue = 0;
		for(int i = 0; i < dictionary.length; i++){
			curLevenValue = levenshtein(word, dictionary[i]);
			if (curLevenValue < minLevenValue) {
				newWord = dictionary[i];
				minLevenValue = curLevenValue;
			} 
		}
		return newWord;
	}

}
