package uk.ac.chester;

import java.util.Arrays;

public class Problems
{
    // ***EXAMPLE***
    // Write a static method which returns the triple of a number
    // it should take an int as a parameter
    // it should return that number, tripled
    static int triple(int number){
        return number * 3;
    }


     // Complete this method which determines if the heating should be on,
     // this should happen if the room temperature is below 19 degrees C
     // it takes a parameter called roomTemperature, indicating a room temperature value in Celsius
     // it should true if the temperature value is below 19, false otherwise
    static boolean heatingShouldBeOn(double roomTemperature)
    {
        return roomTemperature < 19;
    }


    //Write a static method named averageOfThreeNumbers that returns an int
    //It will take three parameters, each one being an int, and return the average (mean) of them
    //The result should be an integer, and so the result should be rounded down if needed
    static int averageOfThreeNumbers(int x, int y, int z)
    {
        return (x + y + z) / 3;
    }


    //Write a static method called concatenatedWords
    //Given 4 strings as parameters, each will hold a single word
    //return the four words separated by spaces
    static String concatenatedWords(String a, String b, String c, String d)
    {
        return a + " " + b + " " + c + " " + d;
    }


     //Write a static method named scrabbleTileValue which returns an int
     //It should take a char as a parameter, which will be lowercase
     //It should return the value of that letter if it was a scrabble tile, as follows:
     // 1: a,e,i,l,n,o,r,s,t,u
     // 2: d,g
     // 3: b,c,m,p
     // 4: f,h,v,w,y
     // 5: k
     // 8: j,x
     // 10: q,z
    static int scrabbleTileValue(char scrabbleLetter)
    {
        char lowercaseLetter = Character.toLowerCase(scrabbleLetter);

        switch (lowercaseLetter)
        {
            case 'a', 'e', 'i', 'l', 'n', 'o', 'r', 's', 't', 'u':
                return 1;
            case 'd', 'g':
                return 2;
            case 'b', 'c', 'm', 'p':
                return 3;
            case 'f', 'h', 'v', 'w', 'y':
                return 4;
            case 'k':
                return 5;
            case 'j', 'x':
                return 8;
            case 'q', 'z':
                return 10;
        }

        return 0;
    }


    /* Write a static method called productOfNumbersInArray
    It should have one parameter, an array of doubles
    Return (as a double) the result of multiplying together all the numbers in the array
    e.g. if the array contained 3, 6 and 7 the result would be 126
    If the array is empty, the value returned should be zero
    */
    static double productOfNumbersInArray(double[] arrayOfDoubles)
    {
        double product = 1;

        if (arrayOfDoubles.length == 0)
        {
            return 0;
        }

        for (double digit : arrayOfDoubles)
        {
            product *= digit;
        }

        return product;
    }


    //create a static method called minValue
    //It should take an array of int as its only parameter
    //it should return an int
    //the method should return the lowest value integer in the array, or 0 if the array is empty
    static int minValue(int[] intArray)
    {
        if (intArray.length == 0)
        {
            return 0;
        }
        else
        {
            Arrays.sort(intArray);
            return intArray[0];
        }
    }


    //Write a static method named sumOfNumbersFromOneToN that returns an int
    //It will take an int as a parameter
    //It should return the sum of the numbers from 1 to the integer passed in (inclusive)
    //The parameter will always be greater than 1
    //e.g. if the parameter has a value of 4, return 10 (i.e. 1+2+3+4)
    static int sumOfNumbersFromOneToN(int num)
    {
        int sum = 0;

        for (int i = 0; i <= num; i++)
        {
            sum += i;
        }

        return sum;
    }


    // Write a static method named removeDoubleSpaces
    // It should take a String as a parameter representing one or more sentences
    // It should return a String representing the input modified as follows:
    // Where a sentence ends in a full stop followed by two (or more) spaces, reduce the number of spaces to one
    // Only remove extra spaces that follow a full stop
    // e.g. "Hello.  World." should become Hello. World.
    static String removeDoubleSpaces(String sentence)
    {
        sentence = sentence.replaceAll("\\.\\s+", ". ");
        return sentence;
    }


    // Write a static method named apaFormatCitation that returns a String
    // It should have two parameters
    // The first should be an array of strings (which will be names of authors)
    // The second should be an integer, which will represent a year
    // using the first text citation format, return a string for the citation
    // this should follow the guide at : http://blog.apastyle.org/apastyle/2011/11/the-proper-use-of-et-al-in-apa-style.html
    static String apaFormatCitation(String[] authors, int year)
    {
        String citation = "";

        if (authors.length == 1)
        {
            citation += authors[0];
        }
        else if (authors.length == 2)
        {
            citation += authors[0] + " & " + authors[1];
        }
        else if (authors.length < 5)
        {
            for (int i = 0; i < authors.length - 1; i++)
            {
                citation += authors[i] + ", ";
            }
            citation += "& " + authors[authors.length - 1];
        }
        else
        {
            citation += authors[0] + " et al.";
        }

        citation += ", ";
        citation += year;

        return citation;
    }


    //Create a static method called isValidBishopMove which will return a boolean and take 4 parameters as follows:
    //char (denoting the current column of the piece on the board), int (denoting the current row of the piece on the board)
    //char (denoting the destination column of the piece on the board), int (denoting the destination row of the piece on the board)
    //the first char and int will indicate a starting position on the board (based on an 8 x 8 chess board)
    //where rows are labelled 1-8 and columns a-h (lowercase letters used)
    //calculate if a given move would be legal for a Bishop piece
    //Bishops can only move diagonally, by at least one square
    static boolean isValidBishopMove(char currentColumn, int currentRow, char destinationColumn, int destinationRow)
    {
        if ((currentColumn + currentRow) == (destinationColumn + destinationRow))
        {
            return false;
        }
        else if (((currentColumn + currentRow) - (destinationColumn + destinationRow)) % 2 == 0)
        {
            return true;
        }

        return false;
    }





     //Write a static method called priceAsString which returns a String
     //It will have three parameters as follows (in order)
     //an integer, representing the the value of a currency in hundreds of the base unit (e.g. pence or cents)
     //a char representing the symbol for the base unit, e.g. £ or $ or € etc.
     //a boolean indicating if the currency unit should be displayed at the end (as opposed to the start)
     //The method should return the value as a string, formatted as a currency with two decimal places
     //e.g. given inputs of 345, '€' and true, return "3.45€"





    // Write a static method named lastPartialMatch
    // It should take two parameters, the first a String, the second an array of Strings
    // It should return an integer
    // this method should return the last index position of the array where it contains
    // (anywhere in the string) the string provided in the first parameter
    // You should ignore the case of the text
    // e.g. the string "his" would be found in the string "THIS"
    // if the text is not located, return -1






   //Write a static method named wordsFromVariableName which, given a String as the parameter, which will be in the form of a
   //Java variable name (such as "myString") return a string which has each word from the variable name with the first letter capitalised, and spaces between the words
   //e.g. "My String"




    // Create a static method called formattedNameFromArray
    //It should have one parameter, an array of Strings and it should return a String
    // This array will contain the names of an individual, in order, and may or may not start with a title (either Dr, Miss, Ms, Mr, Mrs, or Rev)
    //     * there may be 0 or more subsequent names
    //     * the final string in the array will be the surname (or only name - e.g. 'Bono' or 'Cheryl')
    //
    //if they have a title, provide all forenames (if any) in initialised format then the surname as follows
    //     *  with title: Miss. A. B. Stark
    //     *  with title: Mrs. Lannister
    //     *  with title: Ms. D. Targaryen
    //if they do not have a title, print the entire first name, subsequent initials  and surname as follows:
    //     *  without title: Margaery L. Tyrell
    //     *  without title: Jon Snow
    //     *  without title: Shae





    // Write a static method called textChunks that returns an ArrayList of Strings
    // It should have one parameter which is a String (which will contain a sentence)
    // It should return the sentence split into strings 12 chars or less, without breaking words, or making chunks unnecessarily short
    //
    // You need to split the String provided into chunks, each with a maximum of 12 letters, without breaking words up or having chunks that could be longer.
    //
    // As an example, the above sentence split into paragraphs would be as follows:
    //
    // You need to
    // split the
    // String
    // provided
    // into chunks,
    // each with a
    // maximum of
    // 12 letters,
    // without
    // breaking
    // words up or
    // having
    // chunks
    // that could
    // be longer.



}