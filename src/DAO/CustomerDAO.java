package DAO;

import MODEL.Customer;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {

    public void addPerson(Customer c) throws SQLException {
        String sql = "INSERT INTO Customer  VALUES (?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = JDBCConnector.getJDBCConnection().prepareStatement(sql);
        preparedStatement.setString(1, c.getCustomerId());
        preparedStatement.setString(2, c.getName());
        preparedStatement.setInt(3, c.getAge());
        preparedStatement.setString(4, c.getAddress());
        preparedStatement.setString(5, c.getPhoneNumber());
        preparedStatement.setString(6, c.getEmail());
        preparedStatement.setString(7, c.getUsername());
        preparedStatement.executeUpdate();
    }

    public List< Customer> getCustomer() {
        List< Customer> list = new ArrayList<>();
        String sql = "SELECT * FROM Customer";
        try {
            PreparedStatement preparedStatement = JDBCConnector.getJDBCConnection().prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Customer c = new Customer();
                String id = resultSet.getString("customerId");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String address = resultSet.getString("address");
                String phoneNumber = resultSet.getString("phoneNumber");
                String email = resultSet.getString("email");
                String username = resultSet.getString("username");
                c.setCustomerId(id);
                c.setName(name);
                c.setAge(age);
                c.setAddress(address);
                c.setPhoneNumber(phoneNumber);
                c.setEmail(email);
                c.setUsername(username);
                list.add(c);
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static String getPhone(String username) {
        try {
            String sql = "SELECT phoneNumber FROM Customer WHERE username = ?";
            PreparedStatement statement = JDBCConnector.getJDBCConnection().prepareStatement(sql);
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                return resultSet.getString("phoneNumber");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public String getID(String username) {
        try {
            String sql = "SELECT customerId FROM Customer WHERE username = ?";
            PreparedStatement statement = JDBCConnector.getJDBCConnection().prepareStatement(sql);
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                return resultSet.getString("customerId");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public String getName(String customerId) {
        try {
            String sql = "SELECT name FROM Customer WHERE customerId = ?";
            PreparedStatement statement = JDBCConnector.getJDBCConnection().prepareStatement(sql);
            statement.setString(1, customerId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                return resultSet.getString("name");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
    

}
