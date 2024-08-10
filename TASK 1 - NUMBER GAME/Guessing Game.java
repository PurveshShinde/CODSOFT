import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();

        final int LOWER_BOUND = 1;
        final int UPPER_BOUND = 100;
        final int MAX_TRIES = 5;
        int currentScore = 0;

        boolean continuePlaying = true;

        while (continuePlaying) {
            int secretNumber = rand.nextInt(UPPER_BOUND - LOWER_BOUND + 1) + LOWER_BOUND;
            int tries = 0;

            System.out.println("Number Guessing Game Started!");
            System.out.println("Guess the number between " + LOWER_BOUND + " and " + UPPER_BOUND + ".");

            while (tries < MAX_TRIES) {
                System.out.print("Enter your guess (" + (tries + 1) + "/" + MAX_TRIES + "): ");
                int guess = input.nextInt();

                if (guess == secretNumber) {
                    System.out.println("Well done! You found the number.");
                    currentScore++;
                    break;
                } else if (guess < secretNumber) {
                    System.out.println("Too low. Try again.");
                } else {
                    System.out.println("Too high. Try again.");
                }

                tries++;
            }

            if (tries == MAX_TRIES) {
                System.out.println("No more tries left. The number was: " + secretNumber);
            }

            System.out.println("Current score: " + currentScore);

            System.out.print("Play again? (yes/no): ");
            String userChoice = input.next();

            if (!userChoice.equalsIgnoreCase("yes")) {
                continuePlaying = false;
                System.out.println("Game over! Final score: " + currentScore);
            }
        }

        input.close();
    }
}
