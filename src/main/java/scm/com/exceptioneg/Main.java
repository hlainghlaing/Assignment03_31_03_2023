package scm.com.exceptioneg;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        File fileObj = new File("D:\\source\\hello.txt");

        // Use try catch to know error message about one method
        // Even if error exits continue to other method!
        try {
            readFile(fileObj);
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
            e.printStackTrace();
        }

        System.out.println("Continue to other method!");
        try {
            int divResult = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Error");
        }
    }

    // use throw declaration in only one function method
    public static void readFile(File file) throws FileNotFoundException {
        // Use scanner method to catch file
        Scanner input = new Scanner(file);
        String text1 = input.nextLine();
        String text2 = input.nextLine();
        System.out.println("Text in First Line : " + text1);
        System.out.println("Text in Second Line : " + text2);
    }

}
