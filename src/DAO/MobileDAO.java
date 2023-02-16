package DAO;

import MODEL.Mobile;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MobileDAO {
    
    public void addMobile(Mobile b) throws SQLException {
        String sql = "INSERT INTO Mobile VALUES(?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = JDBCConnector.getJDBCConnection().prepareStatement(sql);
        preparedStatement.setString(1, b.getId());
        preparedStatement.setString(2, b.getName());
        preparedStatement.setString(3, b.getColor());
        preparedStatement.setDouble(4, b.getPrice());
        preparedStatement.setInt(5, b.getNumber());
        preparedStatement.setString(6, b.getBrand());
        preparedStatement.setInt(7, b.getMemory());
        preparedStatement.executeUpdate();
    }
    
    public List<Mobile> getMobile() {
        String sql = "SELECT * FROM Mobile";
        List<Mobile> list = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = JDBCConnector.getJDBCConnection().prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Mobile tmp = new Mobile();
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                String color = resultSet.getString("color");
                double price = resultSet.getDouble("price");
                int number = resultSet.getInt("number");
                String brand = resultSet.getString("brand");
                int memory = resultSet.getInt("memory");
                tmp.setId(id);
                tmp.setName(name);
                tmp.setColor(color);
                tmp.setPrice(price);
                tmp.setNumber(number);
                tmp.setBrand(brand);
                tmp.setMemory(memory);
                list.add(tmp);
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public int updateMobile(String id, double price) {
        String sql = "UPDATE Mobile SET price=? WHERE id=?";
        try {
            PreparedStatement preparedStatement = JDBCConnector.getJDBCConnection().prepareStatement(sql);
            preparedStatement.setDouble(1, price);
            preparedStatement.setString(2, id);
            int executeUpdate = preparedStatement.executeUpdate();
            return executeUpdate;
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }
    
    public int deleteMobile(String id) throws SQLException {
        String sql = "DELETE FROM Mobile WHERE id=?";
        PreparedStatement preparedStatement = JDBCConnector.getJDBCConnection().prepareStatement(sql);
        preparedStatement.setString(1, id);
        int executeUpdate = preparedStatement.executeUpdate();
        return executeUpdate;
    }
    
    public List<Mobile> findByName(String name) {
        List<Mobile> list = new ArrayList<>();
        String sql = "SELECT * FROM Mobile WHERE name LIKE ?";
        
        try {
            PreparedStatement preparedStatement = JDBCConnector.getJDBCConnection().prepareStatement(sql);
            preparedStatement.setString(1, name + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Mobile tmp = new Mobile();
                String id = resultSet.getString("id");
                tmp.setName(resultSet.getString("name"));
                String color = resultSet.getString("color");
                double price = resultSet.getDouble("price");
                int number = resultSet.getInt("number");
                String brand = resultSet.getString("brand");
                int memory = resultSet.getInt("memory");
                tmp.setId(id);
                tmp.setColor(color);
                tmp.setPrice(price);
                tmp.setNumber(number);
                tmp.setBrand(brand);
                tmp.setMemory(memory);
                list.add(tmp);
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public List<Mobile> findByPrice(double price) {
        List<Mobile> list = new ArrayList<>();
        String sql = "SELECT * FROM Mobile WHERE price  BETWEEN (? - 0.99) AND (?+0.99)";
        
        try {
            PreparedStatement preparedStatement = JDBCConnector.getJDBCConnection().prepareStatement(sql);
            preparedStatement.setDouble(1, price);
            preparedStatement.setDouble(2, price);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Mobile tmp = new Mobile();
                String id = resultSet.getString("id");
                tmp.setName(resultSet.getString("name"));
                String color = resultSet.getString("color");
                
                int number = resultSet.getInt("number");
                String brand = resultSet.getString("brand");
                int memory = resultSet.getInt("memory");
                tmp.setId(id);
                tmp.setColor(color);
                tmp.setPrice(resultSet.getDouble("price"));
                tmp.setNumber(number);
                tmp.setBrand(brand);
                tmp.setMemory(memory);
                list.add(tmp);
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public int updateNumber(String id) throws SQLException {
        String sql = "UPDATE Mobile SET number=(number-1) WHERE id=?";
        PreparedStatement preparedStatement = JDBCConnector.getJDBCConnection().prepareStatement(sql);
        preparedStatement.setString(1, id);
        int executeUpdate = preparedStatement.executeUpdate();
        return executeUpdate;
    }
    
    public int getNumber(String id) throws SQLException {
        String sql = "SELECT number FROM Mobile WHERE id=?";
        PreparedStatement preparedStatement = JDBCConnector.getJDBCConnection().prepareStatement(sql);
        preparedStatement.setString(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            return resultSet.getInt("number");
        }
        return 0;
    }
    
    public String getName(String id) throws SQLException {
        String sql = "SELECT name FROM Mobile WHERE id=?";
        PreparedStatement preparedStatement = JDBCConnector.getJDBCConnection().prepareStatement(sql);
        preparedStatement.setString(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            return resultSet.getString("name");
        }
        return null;
    }
    
    public double getPrice(String id) throws SQLException {
        String sql = "SELECT price FROM Mobile WHERE id=?";
        PreparedStatement preparedStatement = JDBCConnector.getJDBCConnection().prepareStatement(sql);
        preparedStatement.setString(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            return resultSet.getDouble("price");
        }
        return 0;
    }
    
    public static void main(String[] args) throws SQLException {
        MobileDAO a = new MobileDAO();
//        List<Mobile> list = a.getMobile();
//        for (Mobile tmp : list) {
//            System.out.println(tmp.getName());
//        }
        System.out.println(a.updateNumber("SP01"));
        
    }
    
}
