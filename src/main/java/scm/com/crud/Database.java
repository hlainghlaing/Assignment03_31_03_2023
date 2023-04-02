package scm.com.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

    // url for jdbc
    private String url = "jdbc:mysql://localhost:3306/flowershop";
    private String username = "root";
    private String password = "#hh@root2023";
    // Declare connection object
    private Connection conn;

    public void connect() throws SQLException {
        conn = DriverManager.getConnection(url, username, password);
    }

    public void disconnect() throws SQLException {
        if (conn != null) {
            conn.close();
        }
    }

    public void save(Flowers flowerObj) throws SQLException {
        String itemName = flowerObj.getItemName();
        int itemPrice = flowerObj.getItemPrice();
        int quantity = flowerObj.getQuantity();
        String sql = "insert into itemlist (itemName,itemPrice,quantity) values (?,?,?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, itemName);
        stmt.setInt(2, itemPrice);
        stmt.setInt(3, quantity);
        stmt.execute();

    }

//    public List<Flowers> getItemList() throws SQLException {
//        String sql = "select * from itemlist";
//        Statement stmt = conn.createStatement();
//        ResultSet result = stmt.executeQuery(sql);
//        // To get objects form looping
//        List<Flowers> flowerList = new ArrayList<>();
//        while (result.next()) {
//            int itemId = result.getInt("itemId");
//            String itemName = result.getString("itemName");
//            int itemPrice = result.getInt("itemPrice");
//            int quantity = result.getInt("quantity");
//            Flowers flowerObj = new Flowers(itemId, itemName, itemPrice, quantity);
//            flowerList.add(flowerObj);           
//        }
//       return flowerList;
//    }

    public void getItemList() throws SQLException {
        String sql = "select * from itemlist";
        Statement stmt = conn.createStatement();
        ResultSet result = stmt.executeQuery(sql);
        while (result.next()) {
            int itemId = result.getInt("itemId");
            String itemName = result.getString("itemName");
            int itemPrice = result.getInt("itemPrice");
            int quantity = result.getInt("quantity");
            int total = itemPrice * quantity;
            System.out.print(itemId + " : " + itemName + " : " + itemPrice + " : " + quantity);
            System.out.println("\tTotal " + " : " + total + " ks ");
        }

    }

    public Flowers getItemListById(int itemId) throws SQLException {
        String sql = "select * from itemlist where itemId=" + itemId;
        Statement stmt = conn.createStatement();
        ResultSet result = stmt.executeQuery(sql);
        // To get objects form looping
        Flowers flowerObj = null;
        while (result.next()) {
            String itemName = result.getString("itemName");
            int itemPrice = result.getInt("itemPrice");
            int quantity = result.getInt("quantity");
            flowerObj = new Flowers(itemId, itemName, itemPrice, quantity);
        }
        return flowerObj;
    }

    public void updateItem(Flowers flowerObj) throws SQLException {
        int itemId = flowerObj.getItemId();
        String itemName = flowerObj.getItemName();
        int itemPrice = flowerObj.getItemPrice();
        int quantity = flowerObj.getQuantity();
        String sql = "update itemlist set itemName=?,itemPrice=?,quantity=? where itemId=?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, itemName);
        stmt.setInt(2, itemPrice);
        stmt.setInt(3, quantity);
        stmt.setInt(4, itemId);
        stmt.executeUpdate();
    }

    public void deleteItem(int itemId) throws SQLException {
        String sql = "delete from itemlist where itemId=" + itemId;
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(sql);
    }
}
