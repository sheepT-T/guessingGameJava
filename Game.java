import java.util.Random;
import java.util.Scanner;

public class Game
{
    static int number;
    static int numberGuessed;
    static int counter = 0;

    static void generateNumberToBeGuessed()
    {
        Random ranNumber = new Random();
        number = ranNumber.nextInt(100-1)+ 1;
    }

    static void displayWelcomeMessage()
    {
        System.out.println("Welcome to the Guess the Number Game");
        System.out.println("+++++++++++++++++++++++++++++++++++++");
    }

    static void makeGuess(int guessNumber)
    {
        numberGuessed = guessNumber;
        counter += 1;
    }

    static boolean isCorrectGuess()
    {
        return numberGuessed == number;
    }

    static void displayCorrectGuessMessage()
    {
        if(counter <= 3)
            System.out.println("Great work! You are a mathematical wizard.");
        if(counter >= 4 && counter <= 7)
            System.out.println("Not too bad! You've got some potential.");
        if(counter > 7)
            System.out.println("What took you so long.");
    }

    static void displayPleaseGuessMessage()
    {
        System.out.println("I'm thinking of a number between 1 and 100:");
        System.out.println("Try to guess it.");
    }

    static void displayGuessAgainMessage()
    {
        int difference = numberGuessed - number;
        if(difference > 10)
            System.out.println("Way too high! Guess again.");
        if(difference <= 10 && difference > 0)
            System.out.println("Too high! Guess again.");
        if(difference < -10)
            System.out.println("Way too low! Guess again.");
        if(difference >= -10 && difference < 0)
            System.out.println("Too low. Guess again.");
    }

    public static void main(String[] args)
    {
        int guessNumber = 0;
        Scanner scan = new Scanner(System.in);
        String playAgain = "y";
        displayWelcomeMessage();
        while(playAgain.equals("y"))
        {
            generateNumberToBeGuessed();
            displayPleaseGuessMessage();
            while(guessNumber != number)
            {
                System.out.println("Enter a number between 1 and 100: ");
                guessNumber = scan.nextInt();
                makeGuess(guessNumber);
                if(isCorrectGuess())
                {
                    displayCorrectGuessMessage();
                    break;
                }
                else
                    displayGuessAgainMessage();
            }
            Scanner askPlayAgain = new Scanner(System.in);
            System.out.println("Try Again? (y/n)");
            playAgain = askPlayAgain.next().toLowerCase();
            if (playAgain.equals("n"))
                System.out.println("Bye - Come back soon!");
        }
    }
}
