package scanner.exercise;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class GuessGame
{
    public static void main(String[] args)
    {
        Random rand = new Random();
        int number = rand.nextInt(0,101);
        //System.out.println(number);
        System.out.println("Welcome to GuessGame!\nGuess what number I thought.\nYou have 7 tries.");
        Scanner scan = new Scanner(System.in);
        for(int i = 1;i<=7;i++)
        {
            System.out.print("Guess the number: ");
            try
            {
                int guess = scan.nextInt();
                if(guess<0 || guess>100)
                {
                    throw new IllegalStateException("Number must be from the range [0, 100]");
                }
                if(guess==number)
                {
                    System.out.println("Win in "+i+" try!");
                    break;
                }
                else if(guess>number)
                {
                    System.out.println("My number is lower.");
                }
                else
                {
                    System.out.println("My number is greater.");
                }
                if(i==7)
                {
                    System.out.println("You lose.");
                }
            }
            catch (InputMismatchException e)
            {
                System.out.println("Error! You must write a integer!");
                System.out.println("You lose the round.");
                scan.next();
            }
            catch (IllegalStateException e)
            {
                System.out.println(e.getMessage());
                System.out.println("You lose the round.");
            }

        }

    }


}
