
// KIRJASTO
import java.util.Scanner;
import java.io.IOException;

// KIRJASTO END
public class Main {
    public static void main(String[] arg) {
        Scanner lukija = new Scanner(System.in);
        WordList wordList = new WordList("words.txt");
        Hangman hangman = new Hangman(wordList, 5);

        /*
         * The hidden word...
         * // * * * * * * * *
         * Guesses left: 5
         * Guessed letters: []
         * Guess a letter: e
         */

        while (!hangman.theEnd()) {
            System.out.println("The hidden word...\n");
            System.out.println(hangman.getMaskedWord() + "\n");
            System.out.println("Guesses left: " + hangman.guessesLeft());
            System.out.println("Guessed letters: " + hangman.guesses() + "\n");
            System.out.print("Guess a letter: ");
            String input = lukija.next();
            // Let's make sure it's a letter
            if (input.length() == 1) {
                char letter = input.charAt(0);
                hangman.guess(letter);
            } else {
                System.out.println("Give just one letter, not text!");
            }
        }

        // Game starting here

        // Let's check the win or lose

        if (hangman.isGameWon()) {
            System.out.println("Congratulations! You won!!!");
            System.out.println("The hidden word was: \"" + hangman.word() + "\"");
        } else {
            System.out.println("Sorry, you lost!");
            System.out.println("The hidden word was: \"" + hangman.word() + "\"");
        }

    }
}