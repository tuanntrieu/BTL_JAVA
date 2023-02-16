package MAIN;

import DAO.AccountDAO;
import DAO.BillDAO;
import DAO.CustomerDAO;
import DAO.MobileDAO;
import MODEL.Account;
import MODEL.Bill;
import MODEL.Customer;
import MODEL.Mobile;
import SERVICES.IMP.AccountServiceImp;
import SERVICES.IMP.CustomerServiceImp;
import SERVICES.IMP.MobileServiceImp;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class MainPerson {

    public static Scanner scanner = new Scanner(System.in);

    public static void logIn() throws SQLException {
        System.out.println("Nhập tài khoản: ");
        String username_regex = "^[\\w+]{6,}$";
        String password_regex = "^[\\w+]{6,}$";
        Pattern pattern;
        Matcher matcher;
        String username, password;
        do {
            System.out.print("Tên đăng nhập: ");
            username = scanner.nextLine();
            pattern = Pattern.compile(username_regex);
            matcher = pattern.matcher(username);
            if (matcher.find()) {
                break;
            } else {
                System.out.println("Tên tài khoản phải từ 6 kí tự trở lên, không dấu, không ký tự đặc biệt.");
            }
        } while (!matcher.find());

        do {
            System.out.print("Mật khẩu: ");
            password = scanner.nextLine();
            pattern = Pattern.compile(password_regex);
            matcher = pattern.matcher(password);
            if (matcher.find()) {
                break;
            } else {
                System.out.println("Mật khẩu phải từ 6 kí tự trở lên, không dấu.");
            }
        } while (!matcher.find());
        boolean check = false;
        for (Account tk : MainAccount.listTk()) {
            if (tk.getUsername().equals(username) && tk.getPassword().equals(password) && tk.getRole().equals("admin")) {
                int choseAdmin;
                do {
                    System.out.println(" MENU Admin ");
                    System.out.println("1.Thêm sản phẩm. ");
                    System.out.println("2.Xóa sản phẩm");
                    System.out.println("3.Xem danh sách sản phẩm");
                    System.out.println("4.Cập nhật giá sản phẩm");
                    System.out.println("5.Xem thông tin toàn bộ khách hàng");
                    System.out.println("6.Xem toàn bộ hóa đơn");
                    System.out.println("7.Thoát ");
                    System.out.print("Nhập yêu cầu:  ");
                    choseAdmin = scanner.nextInt();
                    scanner.nextLine();
                    switch (choseAdmin) {
                        case 1: {
                            addProduct();
                            break;
                        }
                        case 2: {
                            deleteProduct();
                            break;
                        }
                        case 3: {
                            showProduct();
                            break;
                        }
                        case 4: {
                            updatePrice();
                            break;
                        }
                        case 5: {
                            showInfor();
                            break;
                        }
                        case 6: {
                            showBill();
                            break;
                        }

                    }
                } while (choseAdmin != 6);
                check = true;
                break;
            }
            if (tk.getUsername().equals(username) && tk.getPassword().equals(password) && tk.getRole().equals("user")) {
                int choseAdmin;
                do {
                    System.out.println(" MENU Customer ");
                    System.out.println("1.Đổi mật khẩu. ");
                    System.out.println("2.Xem danh sách sản phẩm");
                    System.out.println("3.Tìm kiếm sản phẩm theo giá.");
                    System.out.println("4.Tìm kiếm sản phẩm theo hãng");
                    System.out.println("5.Xem danh sách sản phẩm sắp xếp theo giá");
                    System.out.println("6.Thoát ");
                    System.out.print("Nhập yêu cầu:  ");
                    choseAdmin = scanner.nextInt();
                    scanner.nextLine();
                    switch (choseAdmin) {
                        case 1: {
                            changePassword(tk.getUsername());
                            break;
                        }
                        case 2: {
                            showProduct(tk.getUsername());
                            break;
                        }
                        case 3: {
                            findByPrice(tk.getUsername());
                            break;
                        }
                        case 4: {
                            findByName(tk.getUsername());
                            break;
                        }
                        case 5: {
                            sortByPrice(tk.getUsername());
                            break;
                        }
                    }
                } while (choseAdmin != 6);
                check = true;
                break;
            }

        }
        if (!check) {
            System.out.println("Tài khoản không hợp lệ !");
        }
    }

    public static void register() throws SQLException {
        //Enter information for student
        CustomerServiceImp CImp = new CustomerServiceImp();
        CustomerDAO cD = new CustomerDAO();
        Customer customer = new Customer();
        String id = "KH" + String.valueOf(cD.getCustomer().size() + 2);
        CImp.input(customer);
        customer.setCustomerId(id);

        String username = customer.getUsername();
        String password_regex = "^[\\w+]{6,}$";
        Pattern pattern;
        Matcher matcher;
        String password;
        Account tk = new Account();
        tk.setUsername(username);
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
        AccountDAO adao = new AccountDAO();
        adao.addAccount(tk);
        cD.addPerson(customer);
    }

    public static void addProduct() throws SQLException {
        MobileServiceImp MImp = new MobileServiceImp();
        Mobile b = new Mobile();
        MobileDAO mD = new MobileDAO();
        String id = "SP" + String.valueOf(mD.getMobile().size() + 1);
        b.setId(id);
        MImp.input(b);
        mD.addMobile(b);
        System.out.println("Thêm thành công!");
    }

    public static void deleteProduct() throws SQLException {
        System.out.print("Nhập mã sản phẩm muốn xóa: ");
        String id = scanner.nextLine();
        MobileDAO mD = new MobileDAO();
        boolean check = false;
        for (Mobile tmp : mD.getMobile()) {
            if (tmp.getId().equals(id)) {
                if (mD.deleteMobile(id) == 1) {
                    System.out.println("Xoá thành công!");
                    check = true;
                    break;
                }
            }
        }
        if (!check) {
            System.out.println("Không có mã sản phẩm này.");
        }
    }

    public static void showProduct() {
        MobileDAO mD = new MobileDAO();
        MobileServiceImp MImp = new MobileServiceImp();

        System.out.printf("%-15s %-30s %-15s %-15s %-15s %-15s %-15s \n", "ID", "Tên sản phẩm", "Màu", "Giá(triệu đồng)", "Số lượng", "Hãng", "Bộ nhớ");
        List<Mobile> list = mD.getMobile();
        for (Mobile tmp : list) {
            MImp.output(tmp);
        }

    }

    public static void showProduct(String username) throws SQLException {
        MobileDAO mD = new MobileDAO();
        MobileServiceImp MImp = new MobileServiceImp();

        System.out.printf("%-15s %-30s %-15s %-15s %-15s %-15s %-15s \n", "ID", "Tên sản phẩm", "Màu", "Giá(triệu đồng)", "Số lượng", "Hãng", "Bộ nhớ");
        List<Mobile> list = mD.getMobile();
        for (Mobile tmp : list) {
            MImp.output(tmp);
        }
        Buy(list, username);
    }

    public static void Buy(List<Mobile> list, String username) throws SQLException {
        MobileServiceImp MImp = new MobileServiceImp();
        Mobile b = new Mobile();
        MobileDAO mD = new MobileDAO();
        BillDAO bD = new BillDAO();
        CustomerDAO cD = new CustomerDAO();
        System.out.println("Nhập mã sản phẩm bạn muốn mua: ");
        String id;
        int number = 0;
        boolean check = false;
        do {
            id = scanner.nextLine();
            for (Mobile tmp : list) {
                if (tmp.getId().equals(id)) {
                    Bill b1 = new Bill();
                    number = mD.getNumber(id);
                    if (number != 0) {

                        String billID = "B" + String.valueOf(bD.getBill().size() + 1);
                        b1.setBillId(billID);
                        String customerId = cD.getID(username);
                        b1.setCustomerId(customerId);
                        String nameKH = cD.getName(customerId);
                        b1.setNameKH(nameKH);
                        b1.setId(id);
                        b1.setName(mD.getName(id));
                        Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
                        DateFormat dateFormat;
                        dateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy ");
                        String timestampStr = dateFormat.format(currentTimestamp);
                        b1.setPrice(mD.getPrice(id));
                        b1.setTime(timestampStr);
                        bD.addBill(b1);
                        mD.updateNumber(id);
                        printBill(b1);
                        check = true;
                    }
                    break;
                }
            }
            if (!check) {
                System.out.println("Mã sản phẩm không hợp lệ, vui lòng nhập lại");
            }
            if (number == 0) {
                System.out.println("Sản phẩm đã hết hàng");
            }

        } while (!check || number == 0);
    }

    public static void printBill(Bill b) {
        System.out.println("===============HÓA ĐƠN===============");
        System.out.println("Mã hóa đơn:                     " + b.getBillId());
        System.out.println("Mã khách hàng:                  " + b.getCustomerId());
        System.out.println("Tên khách hàng:                 " + b.getNameKH());
        System.out.println("Mã sản phẩm:                    " + b.getId());
        System.out.println("Tên sản phẩm:                   " + b.getName());
        System.out.println("Giá:                            " + b.getPrice() + " triệu");
        System.out.println("Thời gian thanh toán:           " + b.getTime());
        System.out.println("CẢM ƠN QUÝ KHÁCH!");
    }

    public static void showInfor() {
        CustomerDAO cD = new CustomerDAO();
        CustomerServiceImp CImp = new CustomerServiceImp();
        System.out.printf("%-15s %-30s %-15s %-15s %-20s %-50s %-15s\n", "Mã khách hàng", "Tên khách hàng", "Tuổi", "Địa chỉ", "Số điện thoại", "Email", "Tên đăng nhập");
        for (Customer tmp : cD.getCustomer()) {
            CImp.output(tmp);
        }
    }

    public static void updatePrice() {
        System.out.println("Nhập mã sản phẩm cần sửa: ");
        String id = scanner.nextLine();
        MobileDAO mD = new MobileDAO();
        List<Mobile> list = mD.getMobile();
        boolean check1 = false;
        for (Mobile m : list) {
            if (m.getId().equals(id)) {
                boolean check = false;
                double price = 0;
                do {
                    try {
                        System.out.print("Nhập giá(triệu): ");
                        price = scanner.nextDouble();
                        scanner.nextLine();
                        int updateMobile = mD.updateMobile(id, price);
                        if (updateMobile == 1) {
                            System.out.println("Cập nhật thành công!");
                        }
                        check = true;
                        check1 = true;
                        if (price <= 0) {
                            System.out.println("Giá không hợp lệ, vui lòng nhập lại.");
                        }
                    } catch (Exception e) {
                        System.out.println("Giá không hợp lệ, vui lòng nhập lại.");
                        scanner.nextLine();
                    }
                } while (!check || price <= 0);
                break;
            }

        }
        if (!check1) {
            System.out.println("Mã sản phẩm không tồn tại");
        }
    }

    public static void changePassword(String username) {
        AccountDAO aO = new AccountDAO();
        System.out.print("Nhập mật khẩu mới: ");
        String password1 = scanner.nextLine();
        System.out.print("Xác nhận mật khẩu mới: ");
        String pass2;
        do {
            pass2 = scanner.nextLine();
            if (!pass2.equals(password1)) {
                System.out.print("Mật khẩu không khớp, nhập lại: ");
            }
        } while (!pass2.equals(password1));
        aO.updateAccount(username, password1);
        System.out.println("Đổi mật khẩu thành công.");
    }

    public static void findByPrice(String username) throws SQLException {
        MobileDAO mD = new MobileDAO();
        MobileServiceImp mImp = new MobileServiceImp();
        System.out.print("Nhập mức giá cần tìm kiếm(triệu): ");
        double price = scanner.nextDouble();
        if (mD.findByPrice(price).isEmpty()) {
            System.out.println("Không có sản phẩm nào trong tầm giá này.");
        } else {
            List<Mobile> list = mD.findByPrice(price);

            System.out.println("Các sản phẩm trong tầm giá này :");
            System.out.printf("%-15s %-30s %-15s %-15s %-15s %-15s %-15s \n", "ID", "Tên sản phẩm", "Màu", "Giá(triệu đồng)", "Số lượng", "Hãng", "Bộ nhớ");
            for (Mobile tmp : list) {
                mImp.output(tmp);
            }
            Buy(list, username);
        }
    }

    public static void findByName(String username) throws SQLException {
        MobileDAO mD = new MobileDAO();
        MobileServiceImp mImp = new MobileServiceImp();
        System.out.print("Nhập hãng điện thoại cần tìm: ");
        String name = scanner.nextLine();
        if (mD.findByName(name).isEmpty()) {
            System.out.println("Không có sản phẩm nào của hãng này.");
        } else {
            List<Mobile> list = mD.findByName(name);
            System.out.println("Các sản phẩm:");
            System.out.printf("%-15s %-30s %-15s %-15s %-15s %-15s %-15s \n", "ID", "Tên sản phẩm", "Màu", "Giá(triệu đồng)", "Số lượng", "Hãng", "Bộ nhớ");
            for (Mobile tmp : list) {
                mImp.output(tmp);
            }
            Buy(list, username);
        }

    }

    public static void sortByPrice(String username) throws SQLException {
        MobileDAO mD = new MobileDAO();
        MobileServiceImp mImp = new MobileServiceImp();

        List<Mobile> list = mD.getMobile();
        do {
            System.out.println("Mời bạn chọn: ");
            System.out.println("1.Giảm dần\n"
                    + "2.Tăng dần.");
            System.out.print("Chọn: ");
            int choose = scanner.nextInt();

            scanner.nextLine();
            switch (choose) {
                case 2:
                    Collections.sort(list, (Mobile o1, Mobile o2) -> {
                        if (o1.getPrice() < o2.getPrice()) {
                            return -1;
                        } else if (o1.getPrice() > o2.getPrice()) {
                            return 1;
                        } else {
                            return 0;
                        }
                    });
                    break;
                case 1:
                    Collections.sort(list, (Mobile o1, Mobile o2) -> {
                        if (o1.getPrice() < o2.getPrice()) {
                            return 1;
                        } else if (o1.getPrice() > o2.getPrice()) {
                            return -1;
                        } else {
                            return 0;
                        }
                    });
                    break;
                default:
                    System.out.println("Chọn lại:");
                    continue;
            }
            break;
        } while (true);

        System.out.printf(
                "%-15s %-30s %-15s %-15s %-15s %-15s %-15s \n", "ID", "Tên sản phẩm", "Màu", "Giá(triệu đồng)", "Số lượng", "Hãng", "Bộ nhớ");
        for (Mobile tmp : list) {
            mImp.output(tmp);
        }
        Buy(list, username);
    }

    public static void showBill() throws SQLException {
        BillDAO bD = new BillDAO();
        List<Bill> list = bD.getBill();
        if (list.isEmpty()) {
            System.out.println("Chưa có hóa đơn nào!");
        } else {
            System.out.println("DANH SÁCH HÓA ĐƠN");
            System.out.printf("%-10s %-10s %-30s %-10s %-30s %-15s %-30s\n", "Mã hóa đơn", "Mã khách hàng", "Tên khách hàng", "Mã sản phẩm", "Tên sản phẩm", "Giá", "Ngày bán");
            for (Bill b : list) {
                System.out.printf("%-10s %-10s %-30s %-10s %-30s %-15.2f %-30s\n", b.getBillId(), b.getCustomerId(), b.getNameKH(), b.getId(), b.getName(), b.getPrice(), b.getTime());

            }
        }
    }

}
