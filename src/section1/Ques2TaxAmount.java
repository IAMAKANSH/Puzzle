package section1;

import java.util.Scanner;

public class Ques2TaxAmount {


    public static void main(String[] args) {
        /**
         * User input
         */
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the price: ");
        Double price=sc.nextDouble();
        System.out.println("Enter the taxPercentage: ");
        Double taxPercentage= sc.nextDouble();
        //To check whether the input price and taxPercentage is positive
        if(price>=0.0 && taxPercentage>=0.0) {
            Double taxAmt = calculateTax(price, taxPercentage);
            System.out.println(taxAmt);
        }
        else
        {
            System.out.println("Invalid Price/Percentage");
        }

    }

    /**
     * This method calculate the tax
     *
     * Formula :: (taxPercentage*price)/100;
     *
     */
    public static double calculateTax(Double price ,Double taxPercentage)
    {
        return (taxPercentage*price)/100;
    }
}
