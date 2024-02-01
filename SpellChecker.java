
public class SpellChecker {


	public static void main(String[] args) {
		String word = args[0];
		int threshold = Integer.parseInt(args[1]);
		String[] dictionary = readDictionary("dictionary.txt");
		String correction = spellChecker(word, threshold, dictionary);
		System.out.println(correction);
	}

	public static String tail(String str) {
		// Your code goes here
		return "";
	}

	public static int levenshtein(String word1, String word2) {
		// Your code goes here
		return 0;
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
		String newWord = "";
		for(int i = 0; i < dictionary.length; i++){
			if (levenshtein(word, dictionary[i]) <= threshold) {
				newWord = dictionary[i];
			} else{
				return "";
			}
		}
		return newWord;
	}

}
