package section1;

import java.util.Scanner;

public class Ques1HappyBirthday {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Birthday person's name: ");
        String birthdayBoyName=sc.nextLine();
        printBirthdayPoem(birthdayBoyName);
    }

    /**
     * This method print the birthday poem for a birthday boy
     *
     */
    public static void printBirthdayPoem(String name)
    {
        for (int i=0;i<4;i++)
        {
            if(i==2)
                System.out.println("Happy Birthday, dear " + name+ ".");
            else
                System.out.println("Happy Birthday to you!");
        }
    }
}
