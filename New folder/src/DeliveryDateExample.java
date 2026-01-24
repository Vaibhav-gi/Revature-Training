import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class DeliveryDateExample {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        System.out.print("Enter order date (dd-MM-yyyy): ");
        String inputDate = sc.nextLine();

        // Converted the String to LocalDate
        LocalDate orderDate = LocalDate.parse(inputDate, formatter);

        LocalDate deliveryDate = orderDate.plusDays(3);

        System.out.println("Order Date    : " + orderDate.format(formatter));
        System.out.println("Delivery Date : " + deliveryDate.format(formatter));

        sc.close();
    }
}
