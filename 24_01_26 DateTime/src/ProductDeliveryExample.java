import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ProductDeliveryExample {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input date format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        System.out.print("Enter order date (dd-MM-yyyy): ");
        String inputDate = sc.nextLine();

        // Convert String to LocalDate
        LocalDate orderDate = LocalDate.parse(inputDate, formatter);

        // Add 3 days
        LocalDate deliveryDate = orderDate.plusDays(3);

        System.out.println("Order Date    : " + orderDate.format(formatter));
        System.out.println("Delivery Date : " + deliveryDate.format(formatter));

        sc.close();
    }
}
