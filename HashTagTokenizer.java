

public class HashTagTokenizer {

	public static void main(String[] args) {
		String hashTag = args[0];
        hashTag = hashTag.toLowerCase();
		String []dictionary = readDictionary("dictionary.txt");
		breakHashTag(hashTag, dictionary);
		
	}

	//make a new array with all the words in the dictionary
	public static String[] readDictionary(String fileName) {
		String[] dictionary = new String[3000];
		In in = new In(fileName);
		for (int i = 0; i < dictionary.length; i++){
			dictionary [i] = in.readLine();
		}
		return dictionary;
	}

	//checks if the given word exists in the given dictionary
	public static boolean existInDictionary(String word, String []dictionary) {
		boolean exist = false;
		for (int i = 0; i < dictionary.length; i++){
			if (word.equals(dictionary[i]) ) {
				exist = true;
				break;
			}
		}
		return exist;
	}
	// cut the hashtag for existing words and print them
	public static void breakHashTag(String hashtag, String[] dictionary) {
		// Base case: do nothing (return) if hashtag is an empty string.
        if (hashtag.isEmpty()) {
            return;
        }
        int N = hashtag.length();
		String subString = hashtag.substring(0, 0);
		// checks for evdery substing of the worrd if it is a word and print it
        for (int i = 1; i <= N; i++) {
			subString = hashtag.substring(0, i);
			if (existInDictionary(subString, dictionary)){
				System.out.println(subString);
				subString = hashtag.substring(i, N);
				breakHashTag(subString, dictionary);
				return;
			}
        }
    }

}
