package DAO;

import MODEL.Account;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

;

public class AccountDAO {

    public void addAccount(Account tk) throws SQLException {
        String sql = "INSERT INTO Account VALUES(?,?,?)";
        PreparedStatement preparedStatement = JDBCConnector.getJDBCConnection().prepareStatement(sql);
        preparedStatement.setString(1, tk.getUsername());
        preparedStatement.setString(2, tk.getPassword());
        preparedStatement.setString(3, tk.getRole());
        preparedStatement.executeUpdate();
    }

    public List<Account> getAccount() {
        List<Account> accounts = new ArrayList<>();
        String sql = "SELECT * FROM Account";
        try {
            PreparedStatement preparedStatement = JDBCConnector.getJDBCConnection().prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Account account = new Account();
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String role = resultSet.getString("role");
                account.setUsername(username);
                account.setPassword(password);
                account.setRole(role);
                accounts.add(account);
            }
            return accounts;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
//    public static void main(String[] args) {
//        AccountDAO ac =new AccountDAO();
//        List<Account> list=ac.getAccount();
//        System.out.println(list.size());
//    }

//    public void deleteAccount(String username) {
//        String sql = "DELETE FROM Account WHERE username = ?";
//        try {
//            PreparedStatement preparedStatement = JDBCConnector.getJDBCConnection().prepareStatement(sql);
//            preparedStatement.setString(1, username);
//            preparedStatement.executeUpdate();
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//    }

    public void updateAccount(String username, String password) {
        String sql = "UPDATE Account SET password=? WHERE username=?";
        try {
            PreparedStatement preparedStatement = JDBCConnector.getJDBCConnection().prepareStatement(sql);
            preparedStatement.setString(1, password);
            preparedStatement.setString(2, username);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
