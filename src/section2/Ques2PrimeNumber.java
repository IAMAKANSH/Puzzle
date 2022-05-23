package section2;

import java.util.Scanner;

public class Ques2PrimeNumber {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true)
        {
            System.out.print("Enter a number : ");
            int n = sc.nextInt();
            if (checkPrime(n)) {
                System.out.println(n + " is a prime number");
            } else {
                System.out.println(n + " is not a prime number");
            }
            boolean flag=false;
            System.out.println("Do you wish to exit? Y/N");
            if (sc.hasNext()) {
                String answer = sc.next();
                if (answer.equalsIgnoreCase("y"))
                    flag=true;
            }
            if(flag)
                break;
        }
    }

    /**
     * Prime number is number which is divisible by 1 and itself
     * iterate through all numbers from 2 to sqrt(n) and for every number check if it divides n then its not a prime
     *This method check whether the number is prime
     *
     */
    public static boolean checkPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

}
