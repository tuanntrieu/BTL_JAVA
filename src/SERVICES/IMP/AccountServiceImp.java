package SERVICES.IMP;

import MODEL.Account;
import SERVICES.AccountService;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AccountServiceImp implements AccountService {

    @Override
    public void input(Account tk) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" Nhập tài khoản: ");
        String username_regex = "^[\\w+]{6,}$";
        String password_regex = "^[\\w+]{6,}$";
        Pattern pattern;
        Matcher matcher;
        String username,password;
        do {
            System.out.print(" Tên đăng nhập: ");
            username = scanner.nextLine();
            pattern = Pattern.compile(username_regex);
            matcher = pattern.matcher(username);
            if (matcher.find()) {
                tk.setUsername(username);
                break;
            } else {
                System.out.println(" Tên tài khoản phải từ 6 kí tự trở lên, không dấu, không ký tự đặc biệt.");
            }
        } while (!matcher.find());

        do {
            System.out.print(" Mật khẩu: ");
            password = scanner.nextLine();
            pattern = Pattern.compile(password_regex);
            matcher = pattern.matcher(password);
            if (matcher.find()) {
                tk.setPassword(password);
                break;
            } else {
                System.out.println(" Mật khẩu phải từ 6 kí tự trở lên, không dấu.");
            }
        } while (!matcher.find());

        tk.setRole("user");
    }

    @Override
    public void output(Account tk) {
        System.out.printf("%-10s %-10s\n", tk.getUsername(), tk.getPassword());
    }


}
