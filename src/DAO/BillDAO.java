/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import MODEL.Bill;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class BillDAO {

    public List<Bill> getBill() throws SQLException {
        List<Bill> bill = new ArrayList<>();
        String sql = "SELECT * FROM Bill";
        PreparedStatement preparedStatement = JDBCConnector.getJDBCConnection().prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Bill b = new Bill();
            b.setBillId(resultSet.getString("billId"));
            b.setCustomerId(resultSet.getString("customerId"));
            b.setNameKH(resultSet.getString("nameKH"));
            b.setId(resultSet.getString("id"));
            b.setName(resultSet.getString("name"));
            b.setPrice(resultSet.getDouble("price"));
            b.setTime(resultSet.getString("time"));
            bill.add(b);
        }
        return bill;

    }

    public int addBill(Bill b) {
        String sql = "INSERT INTO Bill VALUES(?,?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = JDBCConnector.getJDBCConnection().prepareStatement(sql);
            preparedStatement.setString(1, b.getBillId());
            preparedStatement.setString(2, b.getCustomerId());
            preparedStatement.setString(3, b.getNameKH());
            preparedStatement.setString(4, b.getId());
            preparedStatement.setString(5, b.getName());
            preparedStatement.setDouble(6, b.getPrice());
            preparedStatement.setString(7, b.getTime());
            int executeUpdate = preparedStatement.executeUpdate();
            return executeUpdate;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

}
