/**
 * This program allows the user to play a guessing game where the computer picks 
 * a random number between 1 and MAX_NUMBER and the user tries to guess it.
*/

import java.util.Scanner;

public class GuessGame {

  public static final int MAX_VALUE = 100;

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    introduceGame();
    boolean playAgain = true;
    int totalGames = 0; 
    int totalGuesses = 0;
    int bestGame = Integer.MAX_VALUE;
    while (playAgain) {
      int guesses = playGame();
      totalGuesses += guesses;
      totalGames++;
      if (guesses < bestGame) {
        bestGame = guesses;  
      }
      System.out.print("Play again (Y/N)? ");
      String response = input.next();
      playAgain = response.toUpperCase().startsWith("Y"); 
    }
    showStats(totalGames, totalGuesses, bestGame);
  }
  
  public static void introduceGame() {
    System.out.println("This program allows you to play a guessing game.");
    System.out.println("I will think of a number between 1 and " + MAX_NUMBER + " and will allow you to guess until");
    System.out.println("you get it. For each guess, I will tell you whether");
    System.out.println("the right answer is higher or lower than your guess.");
  }
  
  public static int playGame() {
    Random rand = new Random(); 
    int number = rand.nextInt(MAX_NUMBER) + 1;
    int guesses = 0;
    int guess = 0;
    while (guess != number) {
      System.out.print("Your guess? ");
      guess = input.nextInt();        
      guesses++; 
      if (guess < number) {
        System.out.println("It's higher.");
      }
      else if (guess > number) {
        System.out.println("It's lower.");
      }
    }
    System.out.println("You got it right in " + guesses + " guesses!");
    return guesses;
  }
  
  public static void showStats(int games, int total, int best) {
    double avg = (double) total / games;
    System.out.println("Overall results:");
    System.out.println("  Total games = " + games); 
    System.out.println("  Total guesses = " + total);
    System.out.println("  Guesses/game = " + avg);
    System.out.println("  Best game = " + best);  
  }
}