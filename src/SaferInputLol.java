import java.util.Scanner;
public class SaferInputLol
{
    /**
        @param pipe a Scanner opened to read from System.in
        @param prompt prompt for the user
        @return a String response that is not zero length
     */
    //j//
    public static String getNonZeroLenString(Scanner pipe, String prompt)
    {
        String retString = "";  // Set this to zero length. Loop runs until it isn’t
        do
        {
            System.out.println("\n" + prompt + ": "); // show prompt add space
            retString = pipe.nextLine();
        }while(retString.length() == 0);

        return retString;

    }

    /**
        Gets an integer from user
        @param pipe - gets input
        @param prompt - prompts for integer
        @return - returns integer
     */
    public static int getInt(Scanner pipe, String prompt)
    {
        int retInteger = 0;
        boolean validInt = false;
        String trash = "";
        do
        {
            System.out.print("\n" + prompt);

            if(pipe.hasNextInt())
            {
                retInteger = pipe.nextInt();
                pipe.nextLine();
                validInt = true;
            }
            else
            {
                trash = pipe.nextLine();
                System.out.println("Enter a valid integer, not \"" + trash + "\"");
            }

        }while(!validInt);

        return retInteger;
    }

    /**
        gets a double from user
        @param pipe - gets input
        @param prompt - prompts for double
        @return - returns double
     */
    public static double getDouble(Scanner pipe, String prompt)
    {
        double retDouble = 0;
        boolean validDouble = false;
        String trash = "";
        do
        {
            System.out.print("\n" + prompt);

            if(pipe.hasNextDouble())
            {
                retDouble = pipe.nextDouble();
                pipe.nextLine();
                validDouble = true;
            }
            else
            {
                trash = pipe.nextLine();
                System.out.println("Enter a valid double, not \"" + trash + "\"");
            }


        }while(!validDouble);

        return retDouble;
    }

    /**
        gets a ranged integer from user
        @param pipe - user input
        @param prompt - prompt for input
        @param low - low end of range
        @param high - high end of range
        @return
     */

    public static int getRangedInt(Scanner pipe, String prompt, int low, int high)
    {
        int retInt = 0;
        boolean validInt = false;
        String trash = "";

        do
        {
            System.out.print("\n" + prompt);

            if (pipe.hasNextInt())
            {
                retInt = pipe.nextInt();
                pipe.nextLine();
                if (retInt >= low && retInt <= high)
                {
                    validInt = true;
                }
                else
                {
                    System.out.println("You entered \"" + retInt + "\"");
                    System.out.println("Enter a valid integer [" + low + "-" + high + "]");
                }
            }
            else
            {
                trash = pipe.nextLine();
                System.out.println("Enter a valid integer not \"" + trash + "\"");
            }

        }while(!validInt);

        return retInt;
    }

    /**
        Gets a ranged double from user
        @param pipe - user input
        @param prompt - prompt for input
        @param low - low end of range
        @param high - high end of range
        @return - returns ranged double
     */

    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high)
    {

        double retDouble = 0;
        boolean validDouble = false;
        String trash = "";

        do
        {
            System.out.print("\n" + prompt);

            if (pipe.hasNextDouble())
            {
                retDouble = pipe.nextDouble();
                pipe.nextLine();
                if (retDouble >= low && retDouble <= high)
                {
                    validDouble = true;
                }
                else
                {
                    System.out.println("You entered \"" + retDouble + "\"");
                    System.out.println("Enter a valid double [" + low + "-" + high + "]");
                }
            }
            else
            {
                trash = pipe.nextLine();
                System.out.println("Enter a valid double not \"" + trash + "\"");
            }
        }while(!validDouble);

        return retDouble;
    }

    public static boolean getYNConfirm(Scanner pipe, String prompt)
    {
        boolean retYN = false;
        boolean validInput = false;
        String response;

        do
        {
            System.out.print("\n" + prompt);
            response = pipe.nextLine();
            if(response.equalsIgnoreCase("Y"))
            {
                retYN = true;
                validInput = true;
            }
            else if(response.equalsIgnoreCase("N"))
            {
                retYN = false;
                validInput = true;
            }
            else
            {
                System.out.println("Invalid Input. Enter [Y/N]");
            }
        }while(!validInput);
        return retYN;
    }

    /**
     *
        @param pipe
        @param prompt
        @param regEx
        @return
     */

    public static String getRegExString(Scanner pipe, String prompt, String regEx)
    {
        boolean done = false;
        String trash;
        String retVal;

        do
        {
            System.out.print(prompt + " " + regEx + ": ");
            retVal = pipe.nextLine();

            if (retVal.matches(regEx))
            {
                done = true;
            }
            else
            {
                System.out.println("Enter a matching pattern not: " + retVal);
            }
        }while(!done);

        return retVal;
    }

    public static void prettyHeader(String msg)
    {
        int whiteSpace = (53 - msg.length()) / 2;

        for (int x = 0; x <= 59; x++)
        {
            System.out.print("*");
        }
        System.out.print("\n***");

        for (int x = 0; x <= whiteSpace; x++)
        {
            System.out.print(" ");
        }

        System.out.print(msg);

        for (int x = 0; x <= whiteSpace; x++)
        {
            System.out.print(" ");
        }

        System.out.println("***");

        for (int x = 0; x <= 59; x++)
        {
            System.out.print("*");
        }
    }

}
