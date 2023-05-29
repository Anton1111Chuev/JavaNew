import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {

        Laptop laptop1 = new Laptop("Первый ноутбут", 50, 50);
        Laptop laptop2 = new Laptop("Второй ноутбут", 150, 150);
        Laptop laptop3 = new Laptop("Третий ноутбут", 200, 200);

        SQLlite_Handler sqLliteHandler =  SQLlite_Handler.getInstance();

        sqLliteHandler.addLaptopDB(laptop1);
        sqLliteHandler.addLaptopDB(laptop2);
        sqLliteHandler.addLaptopDB(laptop3);

        System.out.println("Введите: RAM ");
        Scanner in = new Scanner(System.in);
        String RAM = in.nextLine();
        System.out.println("Введите: HD ");
        String HD = in.nextLine();

        System.out.println("Список ноутбуков с лучшими характеристиками: \n"
                + sqLliteHandler.getLaptopsByParam(RAM, HD));
    }
}