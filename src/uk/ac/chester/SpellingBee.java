package uk.ac.chester;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class SpellingBee
{
    public static void main(String[] args)
    {
        ArrayList<Character> allowedLetters = new ArrayList<>();
        ArrayList<String> correctGuesses = new ArrayList<>();

        Scanner inputScanner = new Scanner(System.in);

        // game loop
        System.out.println("SPELLING BEE\n" +
                "Create as many valid 4+ letter words using the given letters as you can.\n" +
                "Words must ALWAYS contain the middle letter.\n" +
                "To exit the game, type 'EXIT' in all caps\n\n");

        // middle letter
        while (true)
        {
            System.out.println("Enter the middle letter:");
            String middleLetter = inputScanner.nextLine();

            if (middleLetter.equals("EXIT"))
            {
                System.out.println("Thanks for playing!");
                System.exit(0);
            }

            if (middleLetterValid(middleLetter))
            {
                char middle = middleLetter.toUpperCase().charAt(0);
                allowedLetters.add(middle);
                break;
            }
        }

        // other letters
        while (allowedLetters.size() < 7)
        {
            System.out.println("\nEnter the other letters:");
            String otherLetters = inputScanner.nextLine();

            if (otherLetters.equals("EXIT"))
            {
                System.out.println("Thanks for playing!");
                System.exit(0);
            }

            appendOtherLetters(otherLetters, allowedLetters);
        }

        // guessing
        while (true)
        {
            System.out.println("\nPlease enter a guess: ");
            String currentGuess = inputScanner.nextLine();

            if (currentGuess.equals("EXIT"))
            {
                System.out.println("Thanks for playing!");
                System.exit(0);
            }

            if (guessIsLongEnough(currentGuess)
                    && containsMiddleLetter(currentGuess, allowedLetters.getFirst())
                    && containsOnlyAllowedLetters(currentGuess, allowedLetters))
            {
                correctGuesses.add(currentGuess);
                System.out.println("Nice! " + currentGuess + " is valid. You now have " +
                        correctGuesses.size() + " correct word(s).");
            }
        }
    }


    private static boolean middleLetterValid(String letter)
    {
        if (letter.isEmpty())
        {
            System.out.println("Middle letter cannot be empty!");
            return false;
        }

        if (letter.length() > 1)
        {
            System.out.println("Middle letter must only be one character!");
            return false;
        }

        char c = letter.charAt(0);

        if (!Character.isLetter(c))
        {
            System.out.println("Middle letter must be a letter! (Not a number or symbol...)");
            return false;
        }

        return true;
    }


    private static void appendOtherLetters(String letters, ArrayList<Character> lettersArray)
    {
        if (letters.isEmpty())
        {
            System.out.println("Please enter some letters!");
            return;
        }

        if (letters.length() != 6)
        {
            System.out.println("Number of surrounding letters must equal 6!");
            return;
        }


        for (char c : letters.toCharArray())
        {
            if (!Character.isLetter(c))
            {
                System.out.println("Only valid lettters allowed!");
                return;
            }
        }

        for (char c : letters.toUpperCase().toCharArray())
        {
            lettersArray.add(c);
        }
    }


    private static boolean guessIsLongEnough(String word)
    {
        if (word.length() < 4)
        {
            System.out.println("Word must be at least four letters long!");
            return false;
        }

        return true;
    }


    private static boolean containsMiddleLetter(String word, char middleLetter)
    {
        if (!word.contains(String.valueOf(middleLetter)))
        {
            System.out.println("Word must contain middle letter! - " + middleLetter);
            return false;
        }

        return true;
    }


    private static boolean containsOnlyAllowedLetters(String word, ArrayList<Character> allowedLetters)
    {
        ;
        char[] wordAsArray = word.toCharArray();

        for (char c : wordAsArray)
        {
            if (!allowedLetters.contains(c))
            {
                System.out.println("Word must only contain the allowed letters! Allowed letters are: ");
                for (Character allowedLetter : allowedLetters)
                {
                    System.out.print(allowedLetter + " ");
                }
                return false;
            }
        }
        return true;
    }

}
