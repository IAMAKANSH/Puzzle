package section1;

import java.util.Scanner;

public class Ques4ReverseName {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (true) {
            System.out.println("Enter name: ");
            String name = sc.nextLine();
            String formattedName = phoneList(name);
            System.out.println(formattedName);
            System.out.println("Please Y for continue and N for exit");
            String response=sc.nextLine();
            if(response.equalsIgnoreCase("n"))
                break;
        }
    }

    /**
     *
     * this method format the name to desired output
     */
    public static String phoneList(String name) {
        String[] splitName = name.trim().split("\\s");
        return splitName[1] + ", " + splitName[0];
    }
}
