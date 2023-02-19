package MAIN;

import static MAIN.MainAccount.forgotPassword;
import static MAIN.MainPerson.logIn;
import static MAIN.MainPerson.register;
import java.sql.SQLException;
import java.util.Scanner;

public class RunMain {

    public static void main(String[] args) throws SQLException {

        do {
            System.out.println("==> WELCOME <==");
            System.out.println("1.Đăng nhập");
            System.out.println("2.Đăng ký");
            System.out.println("3.Quên mật khẩu");
            System.out.print("Nhập lựa chon của bạn : ");
            int chose = new Scanner(System.in).nextInt();
            switch (chose) {
                case 1: {
                   logIn();
                    break;
                }
                case 2: {
                    register();
                    break;
                }
                case 3: {
                    forgotPassword();
                    break;
                }
            }
        } while (true);
    }
}
