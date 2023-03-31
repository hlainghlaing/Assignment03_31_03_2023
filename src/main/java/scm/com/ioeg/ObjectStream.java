package scm.com.ioeg;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectStream {

    public static void main(String[] args) {
        try {
            testObjectOutput();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            testObjectInput();
        } catch (IOException e) {
            System.out.println("Error in testObjectInput Method.");
            e.printStackTrace();
        }
    }

    public static void testObjectOutput() throws IOException {
        // Declare & Instantiate Flower Object
        Flower flowerObj = new Flower("Lavender", 3500);

        ObjectOutputStream oop = null;

        try {
            oop = new ObjectOutputStream(new FileOutputStream("D:\\input\\flowerlist.bin"));
            oop.writeObject(flowerObj);
            System.out.println("Creating Object Output Stream Finished!");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (oop != null) {
                oop.close();
            }
        }
    }

    public static void testObjectInput() throws IOException {
        ObjectInputStream oip = null;
        try {
            oip = new ObjectInputStream(new FileInputStream("D:\\input\\flowerlist.bin"));
            Flower obj = (Flower) oip.readObject();
            System.out.println("Flower Name : " + obj.getFlowerName());
            System.out.println("Flower Price : " + obj.getFlowerPrice());
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found.");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (oip != null) {
                oip.close();
            }
        }
    }

}
