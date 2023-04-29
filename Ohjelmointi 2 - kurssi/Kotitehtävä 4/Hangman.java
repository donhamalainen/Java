
/* KIRJASTO */
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
/* KIRJASTO END */

public class Hangman {

    private Random random = new Random();
    /* ATTRIBUUTIT */
    private String word;
    private int guessesLeft;
    private List<Character> guessedLetters = new ArrayList<>();
    private List<Character> correctLetters = new ArrayList<>();
    /* ATTRIBUUTIT END */

    /* MUODOSTIN */
    public Hangman(WordList words, int attempts) {
        List<String> wordList = words.giveWords();
        // Pick a random word
        word = wordList.get(random.nextInt(wordList.size()));
        this.guessesLeft = attempts;
    }
    /* MUODOSTIN END */

    /* METODIT */

    /*
     * The method compares the character entered as a parameter to the word being
     * guessed and adds the guess
     * to the list of guesses. If the character is found in the word being guessed,
     * the method will return true. If
     * character is not found from the word being guessed, the number of guesses is
     * reduced by one and the
     * method will return false.
     */
    public boolean guess(Character c) {
        // Let's make sure the character is lower case
        c = Character.toLowerCase(c);
        // Let's add the guess to the list of guessedLetters
        if (!guessedLetters.contains(c)) {
            guessedLetters.add(c);
        }

        //
        if (word.contains(Character.toString(c))) {
            correctLetters.add(c);
            return true;
        } else {
            guessesLeft--;
            return false;
        }
    }
    /*
     * The method returns the guesses made (as a List of Character objects). Each
     * character should be in the list
     * only once (even if the user has guessed the same character several times).
     */

    public List<Character> guesses() {
        return guessedLetters;
    }

    /*
     * The method returns the number of remaining guesses. Note, must not be
     * negative
     */
    public int guessesLeft() {
        if (guessesLeft >= 0) {
            return guessesLeft;
        }
        return 0;
    }

    // The method returns the selected word (unmasked, i.e., as read from the file).
    public String word() {
        return word;
    }

    /*
     * The method indicates whether the game is over or not. The game ends if all
     * the letters in the word are
     * guessed correctly.
     */
    public boolean theEnd() {
        if (guessesLeft <= 0) {
            return true;
        }
        for (char c : word.toCharArray()) {
            if (!correctLetters.contains(c)) {
                return false;
            }
        }
        return true;
    }

    public String getMaskedWord() {
        StringBuilder maskedWord = new StringBuilder();
        for (char c : word.toCharArray()) {
            if (correctLetters.contains(c)) {
                maskedWord.append(c);
                maskedWord.append(" ");
            } else {
                maskedWord.append("* ");
            }
        }
        return maskedWord.toString();
    }

    public boolean isGameWon() {
        for (char c : word.toCharArray()) {
            if (!correctLetters.contains(c)) {
                return false;
            }
        }
        return true;
    }
    /* METODIT END */
}
