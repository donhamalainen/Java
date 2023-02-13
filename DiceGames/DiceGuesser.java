import java.util.Scanner;
import java.util.Random;

public class DiceGuesser {
    public static void main(String[] args) {
        int count = 1;
        int low = 2;
        int max = 20;
        Random random = new Random();

        Scanner guess = new Scanner(System.in);
        System.out.println("Guess the number of two dices between 2 - 20:  ");
        Integer guessedNumber = guess.nextInt();
        if (guessedNumber < 2 || guessedNumber > 20) {
            System.out.println("Wrong input... number must be between 2 - 20.");
            System.exit(0);
        } else {
            while (true) {
                int rangeOfRandom = random.nextInt(max) + 1;
                if (rangeOfRandom != guessedNumber) {
                    System.out.println(rangeOfRandom);
                    count++;
                } else {
                    System.out.println(rangeOfRandom);
                    System.out.println("Count of tries to guess: " + count);
                    break;
                }

            }
        }

    }
}
