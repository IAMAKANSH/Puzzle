package section3;

import java.util.Scanner;

public class EncryptionDecryptionApplication {

    /**
     * main class
     *
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Press Y for encrypt N for decrypt :");
        String response = sc.nextLine();
        System.out.println("Enter the letter :");
        String letter = sc.nextLine();
        System.out.println("Enter the key :");
        int key = sc.nextInt();
        StringBuffer result = new StringBuffer();
        if (response.equalsIgnoreCase("y")) {
            if (checkKey(key)) {
                for (int i = 0; i < letter.length(); i++) {
                    if (isALetter(String.valueOf(letter.charAt(i)))) {
                        char encoded = encode(letter.charAt(i), putKeyInRange(key));
                        result.append(encoded);
                    } else
                        result.append(letter.charAt(i));
                }
            }
        } else {
            if (checkKey(key)) {
                for (int i = 0; i < letter.length(); i++) {
                    if (isALetter(String.valueOf(letter.charAt(i)))) {
                        char encoded = decode(letter.charAt(i), putKeyInRange(key));
                        result.append(encoded);
                    } else
                        result.append(letter.charAt(i));
                }
            }
        }
        System.out.println(result);
    }

    /**
     * To check whether a letter is character or not.
     *
     * Input->>A
     * Output->>true
     * Input->>1
     * Output->>false
     *
     */
    public static boolean isALetter(String letter) {
        return Character.isLetter(letter.charAt(0));
    }

    /**
     * This method return a number between 1 and 26(the range of the alphabet)
     *
     */
    public static int putKeyInRange(int encryptKey) {
        return encryptKey % 26;
    }

    /**
     *
     * This method check whether this input key is within range
     */
    public static boolean checkKey(int encryptKey) {
        return encryptKey >= -32767 && encryptKey <= 32768 ? true : false;
    }

    /**
     * This method encrypt the letter with a key
     *
     */
    public static char encode(char letter, int encryKey) {
        if (Character.isUpperCase(letter)) {
            char ch = (char) (((int) letter +
                    encryKey - 65) % 26 + 65);
            return ch;
        } else {
            char ch = (char) (((int) letter +
                    encryKey - 97) % 26 + 97);
            return ch;
        }
    }
    /**
     * This method decrypt the letter with a key
     *
     */
    public static char decode(char letter, int encryKey) {
        if (Character.isUpperCase(letter)) {
            char ch = (char) (((int) letter -
                    encryKey - 65) % 26 + 65);
            return ch;
        } else {
            char ch = (char) (((int) letter -
                    encryKey - 97) % 26 + 97);
            return ch;
        }
    }
}
