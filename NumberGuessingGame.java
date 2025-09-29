package Games;

import java.util.Random;
import java.util.Scanner;

class InvalidGuessException extends Exception {
    public InvalidGuessException(String message) {
        super(message);
    }
}

public class NumberGuessingGame {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int secretNumber = random.nextInt(100) + 1; // 1 to 100
        int attempts = 0;
        boolean guessed = false;

        System.out.println("=== Welcome to Number Guessing Game ===");
        System.out.println("Guess the number between 1 and 100");

        while (!guessed) {
            try {
                System.out.print("Enter your guess: ");
                String input = sc.nextLine();

                // Validate input
                if (!input.matches("\\d+")) {
                    throw new InvalidGuessException("Please enter a valid number!");
                }

                int guess = Integer.parseInt(input);
                if (guess < 1 || guess > 100) {
                    throw new InvalidGuessException("Number must be between 1 and 100!");
                }

                attempts++;

                if (guess < secretNumber) {
                    System.out.println("Too Low! Try again.");
                } else if (guess > secretNumber) {
                    System.out.println("Too High! Try again.");
                } else {
                    System.out.println("🎉 Correct! The number was " + secretNumber);
                    System.out.println("You guessed it in " + attempts + " attempts.");
                    guessed = true;
                }

            } catch (InvalidGuessException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        sc.close();
    }
}
