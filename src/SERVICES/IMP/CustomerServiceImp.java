package SERVICES.IMP;

import DAO.AccountDAO;
import MODEL.Account;
import MODEL.Customer;
import SERVICES.CustomerService;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomerServiceImp implements CustomerService {

    @Override
    public void input(Customer customer) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập thông tin: ");
        System.out.print("Tên: ");
        customer.setName(scanner.nextLine());
        boolean check = false;
        int age = 0;
        do {
            try {
                System.out.print("Tuổi: ");
                age = scanner.nextInt();
                scanner.nextLine();
                check = true;
                if (age <= 0) {
                    System.out.println("Tuổi không hợp lệ, vui lòng nhập lại.");
                }
            } catch (Exception e) {
                System.out.println("Tuổi không hợp lệ, vui lòng nhập lại.");
                scanner.nextLine();
            }
        } while (!check || age <= 0);
        customer.setAge(age);
        System.out.print("Địa chỉ: ");
        customer.setAddress(scanner.nextLine());

        String phone_regex = "^[\\d]{10}$";
        Pattern pattern;
        Matcher matcher;
        String phone;
        do {
            System.out.print("Số điện thoại: ");
            phone = scanner.nextLine();
            pattern = Pattern.compile(phone_regex);
            matcher = pattern.matcher(phone);
            if (matcher.find()) {
                customer.setPhoneNumber(phone);
                break;
            } else {
                System.out.println(" Số điện thoại không hợp lệ, nhập lại.");
            }
        } while (!matcher.find());
        String email_regex = "^[a-z0-9-]+@[a-z0-9]+\\.[a-z]{2,4}$";
        String email;
        do {
            System.out.print("Email: ");
            email = scanner.nextLine();
            pattern = Pattern.compile(email_regex);
            matcher = pattern.matcher(email);
            if (matcher.find()) {
                customer.setEmail(email);
                break;
            } else {
                System.out.println(" Email không hợp lệ, nhập lại.");
            }
        } while (!matcher.find());
        String username_regex = "^[\\w+]{6,}$";
        String username;
        boolean check3;
        do {
            check3 = true;
            System.out.print("Tên đăng nhập: ");
            username = scanner.nextLine();
            pattern = Pattern.compile(username_regex);
            matcher = pattern.matcher(username);
            AccountDAO cD = new AccountDAO();
            for (Account tmp : cD.getAccount()) {
                if (tmp.getUsername().equals(username)) {
                    System.out.println("Tài khoản tồn tại, vui lòng nhập lại.");
                    check3 = false;
                }
            }
            if (matcher.find()) {
                if (check3) {
                    customer.setUsername(username);
                    break;
                }
            } else {
                System.out.println(" Tên tài khoản phải từ 6 kí tự trở lên, không dấu, không ký tự đặc biệt.");
            }

        } while (!matcher.find() || !check3);
    }

    @Override
    public void output(Customer customer) {
        System.out.printf("%-15s %-30s %-15d %-15s %-20s %-50s %-15s\n", customer.getCustomerId(), customer.getName(), customer.getAge(), customer.getAddress(), customer.getPhoneNumber(), customer.getEmail(), customer.getUsername());
    }

    public static void main(String[] args) {
        CustomerServiceImp c = new CustomerServiceImp();
        Customer customer = new Customer();
        c.input(customer);
        //  c.output(customer);
    }
}
