package scm.com.crud;

import java.sql.*;
import java.util.Iterator;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // Declare & Instantiate Database Object
        Database dbObj = new Database();
        try {
            dbObj.connect();
            System.out.println("Connected!");
        } catch (SQLException e) {
            System.out.println("Disconnect!");
            e.printStackTrace();
        }

        try {
            // Flowers flowerObj = new Flowers("Jasmine", 50, 100);
            // dbObj.save(flowerObj);
            // List<Flowers> listObj = dbObj.getItemList();
            dbObj.getItemList();
            Flowers flower = dbObj.getItemListById(3);
            System.out.print(flower.getItemId() + " : " + flower.getItemName() + " : " + flower.getItemPrice());
            System.out.println(" : " + flower.getQuantity());
            flower.setQuantity(30);
            dbObj.updateItem(flower);
            dbObj.deleteItem(4);
            System.out.println("Success!");
        } catch (SQLException e) {
            System.out.println("Failed!");
            e.printStackTrace();
        }

        try {
            dbObj.disconnect();
            System.out.println("Connection Closed!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
