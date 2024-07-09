import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class GuessNumberGame {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 1000;
    private static final int MAX_ATTEMPTS = 10;

    public static void main(String[] args) {
        GuessNumberGame game = new GuessNumberGame();
        game.startGame();
    }

    public void startGame() {
        boolean isUserGuessCorrect = false;
        int numberOfGuesses = 0;
        // computer thinks a number
        int computerNumber = getNumberByComputer();

        // Program continues till user guesses the number correctly or runs out of attempts
        while (!isUserGuessCorrect && numberOfGuesses < MAX_ATTEMPTS) {
            int userNumber = getUserGuessedNumber();
            if (userNumber > computerNumber) {
                System.out.println("Sorry, the number you guessed is too high.");
            } else if (userNumber < computerNumber) {
                System.out.println("Sorry, the number you guessed is too low.");
            } else {
                System.out.println("Congratulations! Your guess is correct!");
                isUserGuessCorrect = true;
            }
            numberOfGuesses++;
        }
        
        if (!isUserGuessCorrect) {
            System.out.println("Oops! Your chances are finished. The correct number was " + computerNumber + ".");
        } else {
            System.out.println("You found the number in " + numberOfGuesses + " guesses.");
        }
    }

    public int getNumberByComputer() {
        return ThreadLocalRandom.current().nextInt(MIN_NUMBER, MAX_NUMBER + 1);
    }

    public int getUserGuessedNumber() {
        Scanner sn = new Scanner(System.in);
        int userNumber = 0;
        boolean validInput = false;
        
        while (!validInput) {
            System.out.print("Please guess the number: ");
            if (sn.hasNextInt()) {
                userNumber = sn.nextInt();
                if (userNumber >= MIN_NUMBER && userNumber <= MAX_NUMBER) {
                    validInput = true;
                } else {
                    System.out.println("Please enter a number between " + MIN_NUMBER + " and "+ MAX_NUMBER + ".");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid integer.");
                sn.next(); // clear the invalid input
            }
        }
        return userNumber;
    }
}