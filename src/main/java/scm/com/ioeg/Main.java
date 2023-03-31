package scm.com.ioeg;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        
        // call static method testByteStream
        try {
            testByteStream();
        } catch (IOException e) {
            System.out.println("Error in testByteStream Method.");
        }
        
        // Call static method testCharStream
        try {
            testCharStream();
        } catch (IOException e) {
            System.out.println("Error in testCharStream Method.");
        }
        
    }

    public static void testByteStream() throws IOException {

        File source = new File ("D:\\input\\img_cartoon.jpg");
        File target = new File("D:\\output\\img_cartoon_output.png");
        
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
             fis = new FileInputStream(source);
             fos = new FileOutputStream(target);
            int code;
            while ((code = fis.read()) != -1) {
                fos.write(code);
            }
            System.out.println("Creating Output Picture Finished!");
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found!");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fis != null) {
                fis.close();
            }
            if (fos != null) {
                fos.close();
            }
            
        }

    }
    
    public static void testCharStream() throws IOException {
        File source = new File("D:\\input\\input.txt");
        File target = new File("D:\\output\\output.txt");
        FileReader fr = null;
        FileWriter fw = null;
         
        try {
            fr = new FileReader(source);
            fw = new FileWriter(target);
            int code;
            while((code=fr.read())!= -1) {
                fw.write(code);
            }
            System.out.println("Creating output text file Finished!");
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found.");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fr != null) {
                fr.close();
            }
            if (fw != null) {
                fw.close();
            }
        }
        
        
        
    }

}
