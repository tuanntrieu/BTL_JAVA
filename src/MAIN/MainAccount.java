package MAIN;

import DAO.AccountDAO;
import DAO.CustomerDAO;
import MODEL.Account;
import java.util.List;
import java.util.Scanner;

public class MainAccount {

    public static List<Account> listTk() {
        AccountDAO accountDAO = new AccountDAO();
        return accountDAO.getAccount();
    }

    public static void forgotPassword() {
        AccountDAO aO = new AccountDAO();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập tên tài khoản: ");
        boolean check = false;
        String username;
        do {
            username = scanner.nextLine();
            for (Account tmp : listTk()) {
                if (username.equals(tmp.getUsername())) {
                    check = true;
                    break;
                }
            }
            if (!check) {
                System.out.println("Tài khoản không tồn tại, vui lòng nhập lại. ");
            }
        } while (!check);
        System.out.println("Xác thực tài khoản: ");
        System.out.print("Nhập số điện thoại khách hàng: ");
        boolean check2 = false;
        String phone;
        do {
            phone = scanner.nextLine();
            if (phone.equals(CustomerDAO.getPhone(username))) {

                System.out.println("Nhập mật khẩu mới: ");
                String password = scanner.nextLine();
                System.out.println("Xác nhận mật khẩu mới: ");
                String pass2 ;
                do {
                    pass2 = scanner.nextLine();
                    if (!pass2.equals(password)) {
                        System.out.print("Mật khẩu không khớp, nhập lại: ");
                    }
                } while (!pass2.equals(password));
                aO.updateAccount(username, password);
                System.out.println("Đổi mật khẩu thành công.");
                check2 = true;
                break;
            }
            if (!check2) {
                System.out.print("Số điện thoại không khớp, nhập lại: ");
            }

        } while (!check2);

    }

    public static void changePassword(String username) {
        Scanner scanner = new Scanner(System.in);
        AccountDAO aO = new AccountDAO();
        System.out.println("Nhập mật khẩu mới: ");
        String password = scanner.nextLine();
        System.out.println("Xác nhận mật khẩu mới: ");
        String pass2 = "";
        do {
            pass2 = scanner.nextLine();
            if (!pass2.equals(password)) {
                System.out.print("Mật khẩu không khớp, nhập lại: ");
            }
        } while (!pass2.equals(password));
        aO.updateAccount(username, password);
        System.out.println("Đổi mật khẩu thành công.");
    }

    public static void main(String[] args) {
     
    }
}
