package uk.ac.chester;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class SpellingBee
{
    public static void main(String[] args)
    {
        Scanner inputScanner = new Scanner(System.in);
        // user input to char array

        System.out.println("SPELLING BEE\n" +
                "Create as many valid words using the given letters as you can.\n" +
                "Words must ALWAYS contain the middle letter.\n" +
                "To exit the game, type 'EXIT'\n\n");

        String userInput = inputScanner.nextLine();
    }

    public boolean checkWordValid(String guessWord, String middleLetter)
    {
        String uppercaseGuessWord = guessWord.toUpperCase();
        String uppercaseMiddleLetter = middleLetter.toUpperCase();

        if (guessWord.length() < 4)
        {
            return false;
        }

        if (!guessWord.contains(middleLetter))
        {
            return false;
        }


    }
}
