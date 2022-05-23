package section2;

import java.util.Scanner;

public class Ques1HidingPassword {
    /**
     *When entering the passwords, the computer often returns hiding characters that hide the passwords that is entered
     *
     * For Example::
     *
     * Input String::
     *
     * "All gophers are named Fred" and character is "*"
     *
     * Output is "*** ******* *** ***** ****"
     */
        public static void main(String[] args) {

            Scanner sc=new Scanner(System.in);
            System.out.println("Enter the string");
            String inputString=sc.nextLine();
            System.out.println("Enter the hideChars");
            char hideChars=sc.next().charAt(0);
            String result=hideChars(inputString,hideChars);
            System.out.println(result);

        }

    /**
     *This method hides the inputString with the hide Character
     */
        public static String hideChars(String inputString, char hideChars)
        {
            String hiddenString ="";
            for (int i=0;i<inputString.length();i++)
            {
                if(isASpace(inputString.charAt(i)))
                    hiddenString +=" ";
                else
                    hiddenString +=hideChars;

            }
            return  hiddenString;
        }

    /**
     *check whether the character is whitespace or not
     */
    public static Boolean isASpace(char inputString)
        {
            return Character.isWhitespace(inputString);
        }
}
