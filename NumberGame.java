import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Random random = new Random();
            
            int minRange = 1;
            int maxRange = 100;
            int maxAttempts = 10;
            int score = 0;
            
            boolean playAgain = true;
            
            System.out.println("Welcome to the Number Game!");
            
            while (playAgain) {
                int targetNumber = random.nextInt(maxRange - minRange + 1) + minRange;
                int attempts = 0;
                
                System.out.println("\nGuess the number between " + minRange + " and " + maxRange + ".");
                
                while (attempts < maxAttempts) {
                    System.out.print("Attempt " + (attempts + 1) + ": Enter your guess: ");
                    int guess = scanner.nextInt();
                    
                    if (guess == targetNumber) {
                        System.out.println("Congratulations! You guessed the correct number.");
                        score++;
                        break;
                    } else if (guess < targetNumber) {
                        System.out.println("Too low. Try again.");
                    } else {
                        System.out.println("Too high. Try again.");
                    }
                    
                    attempts++;
                }
                
                if (attempts == maxAttempts) {
                    System.out.println("Out of attempts. The correct number was: " + targetNumber);
                }
                
                System.out.print("Do you want to play again? (yes/no): ");
                String playAgainInput = scanner.next();
                playAgain = playAgainInput.equalsIgnoreCase("yes");
            }
            
            System.out.println("Game over. Your final score: " + score);
        }
    }
}
