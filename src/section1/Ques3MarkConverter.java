package section1;

import java.util.Scanner;

public class Ques3MarkConverter {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        while (true) {
            System.out.println("Enter the Level :");
            String level = sc.nextLine();
            if(validateLevel(level))
                display(level);
            else
                System.out.println("Level Pattern is Invalid");

            System.out.println("Type Y if want to continue otherwise N for not");
            String response=sc.nextLine();
            if(response.equalsIgnoreCase("n"))
                break;
        }
    }

    /**
     *This method is to validate the level
     */
    public static Boolean validateLevel(String level)
    {
        //regex is used for defining design patterns
        /**
         *  | -> OR statement in regex
         *  Either we can have "R" or any digit range 1-4[1,2,3,4] and +/- sign along with digit
         *  If any input String matches the pattern it will return true else false
         *  It is open for extension
         */
        return level.matches("(R|[1-4][+-])");
    }

    /**
     * this method display the mark range
     */
    public static void display(String level)
    {
        switch (level)
        {
            case "R":
                System.out.println("0 to 49");
                break;
            case "1-":
                System.out.println("50 to 54");
                break;
            case "1+":
                System.out.println("55 to 59");
                break;
            case "2-":
                System.out.println("60 to 64");
                break;
            case "2+":
                System.out.println("64 to 69");
                break;
            case "3-":
                System.out.println("70 to 74");
                break;
            case "3+":
                System.out.println("75 to 79");
                break;
            case "4-":
                System.out.println("80 to 89");
                break;
            case "4+":
                System.out.println("90 to 100");
                break;
            default:
                System.out.println("Level Not Found");
        }
    }
}
