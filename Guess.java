import java.util.Scanner;

public class Guess {
    // Constant for the maximum number used in the guessing game
    private static final int MAX_NUMBER = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Introduction
        introduceGame();

        // Play multiple games
        int totalGames = 0;
        int totalGuesses = 0;
        int bestGuesses = Integer.MAX_VALUE;

        while (true) {
            // Play one game
            int guesses = playGame(scanner);

            // Update statistics
            totalGames++;
            totalGuesses += guesses;
            bestGuesses = Math.min(bestGuesses, guesses);

            // Ask user if they want to play again
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.next();

            if (!playAgain.startsWith("y") && !playAgain.startsWith("Y")) {
                break;
            }
        }

        // Report overall results
        reportResults(totalGames, totalGuesses, bestGuesses);

        // Close the scanner
        scanner.close();
    }

    // Method that introduces the game to the user
    private static void introduceGame() {
        System.out.println("Welcome to the Guessing Game!");
        System.out.println("I'm thinking of a number between 1 and " + MAX_NUMBER);
        System.out.println("Try to guess it!");
    }

    // Method to play one game with the user
    private static int playGame(Scanner scanner) {
        int answer = (int) (Math.random() * MAX_NUMBER) + 1;
        int guesses = 0;

        while (true) {
            System.out.print("Enter your guess: ");
            int userGuess = scanner.nextInt();
            guesses++;

            if (userGuess == answer) {
                System.out.println("You got it right in " + guesses + " guess" + (guesses == 1 ? "" : "es"));
                break;
            } else {
                System.out.println(userGuess < answer ? "Higher!" : "Lower!");
            }
        }

        return guesses;
    }

    // Method to report overall results to the user
    private static void reportResults(int totalGames, int totalGuesses, int bestGuesses) {
        double averageGuesses = (double) totalGuesses / totalGames;

        System.out.println("\nOverall Results:");
        System.out.println("Total games played: " + totalGames);
        System.out.println("Total guesses made: " + totalGuesses);
        System.out.printf("Average guesses per game: %.1f%n", averageGuesses);
        System.out.println("Best (fewest) number of guesses in a single game: " + bestGuesses);
    }
}
