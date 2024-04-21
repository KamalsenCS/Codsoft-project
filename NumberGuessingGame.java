import java.util.*;
import java.io.*;

class NumberGuessingGame 
{
  public static void main(String[] args) throws IOException
  {    
        InputStreamReader i=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(i);
        
        Random random = new Random();
        boolean playAgain = true;
        int totalAttempts = 0;
        int roundsPlayed = 0;
         
        while (playAgain)
        {
            roundsPlayed++;
            int attempts = 0;
            int numberToGuess = random.nextInt(100) + 1;

            System.out.println("\nRound " + roundsPlayed + ": 
            I have chosen a number between 1 and 100. Can you guess it?");
            
            while (true)
             {
                attempts++;
                totalAttempts++;
                System.out.print("Enter your guess (between 1 and 100): ");
              
                 String s=br.readLine();
                 int userGuess=Integer.parseInt(s);

                if (userGuess < 1 || userGuess > 100) 
                {
                    System.out.println("Please enter a number between 1 and 100.");
                    continue;
                }

                if (userGuess == numberToGuess) 
                {
                    System.out.println("Congratulations! You guessed the number " +
                     numberToGuess + " correctly in " + attempts + " attempts.");
                    break;
                }
                else if (userGuess < numberToGuess)
                {
                    System.out.println("Too low! Try again.");
                } 
                else 
                {
                    System.out.println("Too high! Try again.");
                }
                if (attempts == 5) 
                {
                    System.out.println("You've used all your attempts. The
                     correct number was " + numberToGuess + ".");
                    break;
                }
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = br.readLine();
            playAgain = playAgainInput.equalsIgnoreCase("yes");
        }

        System.out.println("\nThank you for playing!");
        System.out.println("Total rounds played: " + roundsPlayed);
        System.out.println("Total attempts made: " + totalAttempts);

        br.close();
    }
}
