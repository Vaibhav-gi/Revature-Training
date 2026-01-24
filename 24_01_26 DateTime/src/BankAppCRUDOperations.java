import java.sql.*;
import java.util.Scanner;

public class BankAppCRUDOperations {

    static final String URL = "jdbc:mysql://localhost:3306/bankapp";
    static final String USER = "root";
    static final String PASSWORD = "manager";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("1. Insert");
        System.out.println("2. View");
        System.out.println("3. Update");
        System.out.println("4. Delete");
        System.out.print("Enter choice: ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1 -> insertCustomer(sc);
            case 2 -> viewCustomers();
            case 3 -> updateCustomer(sc);
            case 4 -> deleteCustomer(sc);
            default -> System.out.println("Invalid Choice");
        }

        sc.close();
    }


    static void insertCustomer(Scanner sc) {
        String sql = "INSERT INTO customer VALUES (?, ?, ?, ?)";

        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = con.prepareStatement(sql)) {

            System.out.print("Enter ID: ");
            ps.setInt(1, sc.nextInt());

            System.out.print("Enter Name: ");
            ps.setString(2, sc.next());

            System.out.print("Enter Email: ");
            ps.setString(3, sc.next());

            System.out.print("Enter Account Name: ");
            ps.setString(4, sc.next());

            ps.executeUpdate();
            System.out.println("Customer Inserted Successfully");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    static void viewCustomers() {
        String sql = "SELECT * FROM customer";

        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " " +
                                rs.getString("name") + " " +
                                rs.getString("email") + " " +
                                rs.getString("accountname")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    static void updateCustomer(Scanner sc) {
        String sql = "UPDATE customer SET email=? WHERE id=?";

        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = con.prepareStatement(sql)) {

            System.out.print("Enter ID: ");
            ps.setInt(2, sc.nextInt());

            System.out.print("Enter New Email: ");
            ps.setString(1, sc.next());

            ps.executeUpdate();
            System.out.println("Customer Updated Successfully");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    static void deleteCustomer(Scanner sc) {
        String sql = "DELETE FROM customer WHERE id=?";

        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = con.prepareStatement(sql)) {

            System.out.print("Enter ID to delete: ");
            ps.setInt(1, sc.nextInt());

            ps.executeUpdate();
            System.out.println("Customer Deleted Successfully");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
