package SERVICES.IMP;

import MODEL.Mobile;
import SERVICES.MobileService;
import java.util.Scanner;

public class MobileServiceImp implements MobileService {

    @Override
    public void input(Mobile b) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập thông tin: ");
        System.out.print("Tên máy: ");
        b.setName(scanner.nextLine());
        System.out.print("Màu: ");
        b.setColor(scanner.nextLine());
        boolean check = false;
        double price = 0;
        do {
            try {
                System.out.print("Giá(triệu): ");
                price = scanner.nextDouble();
                scanner.nextLine();
                check = true;
                if (price <= 0) {
                    System.out.println("Giá không hợp lệ, vui lòng nhập lại.");
                }
            } catch (Exception e) {
                System.out.println("Giá không hợp lệ, vui lòng nhập lại.");
                scanner.nextLine();
            }
        } while (!check || price <= 0);
        b.setPrice(price);
        boolean check1 = false;
        int number = 0;
        do {
            try {
                System.out.print("Số lượng: ");
                number = scanner.nextInt();
                scanner.nextLine();
                check1 = true;
                if (number <= 0) {
                    System.out.println("Số lượng không hợp lệ, vui lòng nhập lại.");
                }
            } catch (Exception e) {
                System.out.println("Số lượng không hợp lệ, vui lòng nhập lại.");
                scanner.nextLine();
            }
        } while (!check1 || number <= 0);
        b.setNumber(number);
        System.out.print("Hãng sản xuất: ");
        b.setBrand(scanner.nextLine());
        boolean check3 = false;
        int memory = 0;
        do {
            try {
                System.out.print("Dung lượng bộ nhớ: ");
                memory = scanner.nextInt();
                scanner.nextLine();
                check3 = true;
                if (memory <= 0) {
                    System.out.println("Dung lượng không hợp lệ, vui lòng nhập lại.");
                }
            } catch (Exception e) {
                System.out.println("Dung lượng không hợp lệ, vui lòng nhập lại.");
                scanner.nextLine();
            }
        } while (!check3 || memory <= 0);
        b.setMemory(memory);
    }

    @Override
    public void output(Mobile b) {
        System.out.printf("%-15s %-30s %-15s %-15.3f %-15d %-15s %-15d\n", b.getId(), b.getName(), b.getColor(), b.getPrice(), b.getNumber(), b.getBrand(), b.getMemory());
    }

    public static void main(String[] args) {
        MobileServiceImp m = new MobileServiceImp();
        Mobile b = new Mobile();
        m.input(b);
        m.output(b);
    }
}
