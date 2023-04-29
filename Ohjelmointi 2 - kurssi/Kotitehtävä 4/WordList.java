
/* KIRJASTO */
import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.Console;
import java.io.FileReader;
import java.io.IOException;
/* KIRJASTO END */

public class WordList {

    /*
     * The words are in a text file, one word per line. You can assume that there
     * are no special characters in the words (just
     * alphabets). In words, uppercase and lowercase letters must be handled as the
     * same letters (i.e., ‘e’ or ‘E’ entered by
     * the user are considered the same).
     */

    /* ATTRIBUUTIT */
    private List<String> words = new ArrayList<String>();
    /* ATTRIBUUTIT END */

    /* MUODOSTIN */
    public WordList(String fileName) {
        try {
            BufferedReader tiedostoLukija = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = tiedostoLukija.readLine()) != null) {
                words.add(line);
            }
            tiedostoLukija.close();
        } catch (IOException e) {
            System.out.println("Tiedoston latauksessa ilmeni virhe");
        }
    }

    public WordList(List<String> words) {
        this.words = words;
    }
    /* MUODOSTIN END */

    /* METODIT */
    public List<String> giveWords() {
        List<String> lowerCase = new ArrayList<>();
        for (String word : words) {
            lowerCase.add(word.toLowerCase());
        }
        return lowerCase;
    }

    /* BONUS TASK */

    /*
     * The method returns a new WordList object with only the words whose length
     * corresponds to the value of
     * the variable given as a parameter.
     */
    public WordList theWordsOfLength(int length) {
        List<String> filteredWords = new ArrayList<>();
        for (String word : words) {
            if (word.length() == length) {
                filteredWords.add(word);
            }
        }
        WordList filteredWordList = new WordList(filteredWords);
        return filteredWordList;
    }

    /*
     * The method returns a new WordList object with only the words with the letters
     * in the exact positions
     * specified in the given string (and matching the length of that given string).
     * For example, the given string is in the format _a_e_ (matching words would be
     * for example camel or panel)
     * where the lines represent any letter and other letters must be in the given
     * positions in the word.
     */
    public WordList theWordsWithCharacters(String someString) {
        List<String> filteredWords = new ArrayList<>();

        for (String word : words) {
            boolean match = true;

            if (word.length() != someString.length()) {
                continue;
            }

            for (int i = 0; i < word.length(); i++) {
                char wordChar = word.charAt(i);
                char someStringChar = someString.charAt(i);

                if (someStringChar != '_' && someStringChar != wordChar) {
                    match = false;
                    break;
                }
            }

            if (match) {
                filteredWords.add(word);
            }
        }

        WordList filteredWordList = new WordList(filteredWords);
        return filteredWordList;
    }
    /* METODIT END */
}
