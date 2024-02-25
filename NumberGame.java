
import java.util.*;

public class NumberGame {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rd = new Random();

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I'm thinking of a number between 1 to 100. Can you guess it?");

        int secretNumber = rd.nextInt(100) + 1;
        int limits = 7;
        int attempts = 0;

        while (attempts < limits) {
            System.out.println("Enter your guess: ");
            int userGuess = sc.nextInt();
            attempts++;

            if (userGuess == secretNumber) {
                System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                break;
            } else if (attempts == limits) {
                     System.out.println("Sorry, you've run out of attempts. The correct number was " + secretNumber);
                 }else if (userGuess < secretNumber) {
                System.out.println("Try again. The secret number is greater than your guess.");
            } else {
                System.out.println("Try again. The secret number is less than your guess.");
            }
        }
    }
}