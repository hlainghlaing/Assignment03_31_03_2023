package scm.com.ioeg;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataStream {

    public static void main(String[] args) {
        try {
            testDataOutput();
        } catch (IOException e) {
            System.out.println("Error in testDataOutput Method.");
        }

        try {
            testDataInput();
        } catch (IOException e) {
            System.out.println("Error in testDataInput Method.");
        }
    }

    public static void testDataOutput() throws IOException {
        String[] products = { "Facial Form", "Suncreen", "Lotion", "Toner", "Shower", "Serum", "Hair Coat" };
        int[] prices = { 8000, 5000, 6500, 12000, 5500, 6500, 3500 };

        DataOutputStream out = null;

        try {
            out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("D:\\input\\productlist.txt")));
            for (int i = 0; i < products.length; i++) {
                out.writeUTF(products[i]);
                out.writeInt(prices[i]);
            }
            System.out.println("Creating File DataOutput Finished!");
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found.");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

    public static void testDataInput() throws IOException {
        DataInputStream in = null;
        try {
            in = new DataInputStream(new BufferedInputStream(new FileInputStream("D:\\input\\productlist.txt")));
            try {
                while (true) {
                    String item = in.readUTF();
                    int priceItem = in.readInt();
                    System.out.println(item + " : " + priceItem);
                }
            } catch (EOFException e) {
                System.out.println("No Data To Read ! Finished.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found.");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                in.close();
            }
        }
    }

}
