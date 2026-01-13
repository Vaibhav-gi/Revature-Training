package fundamental;

import java.util.Scanner;

public class Restaurant {
    public static void main(String[] args) {
        System.out.println("Welcome to Vaibhav Restaurant");
        System.out.println("Do you want to order 'Y' or 'N'?");
        Scanner scanner = new Scanner(System.in);
        char choice = scanner.next().charAt(0);
        if (choice == 'Y') {
            System.out.println("1.\t\t Snacks");
            System.out.println("2.\t\t Meal");
            System.out.println("3.\t\t Dinner");
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    System.out.println("Snacks Items");
                    System.out.println("1.\t Idli Sambhar");
                    System.out.println("2.\t Poha");
                    break;
                case 2:
                    System.out.println("Meal Items");
                    System.out.println("1. Punjabi thali");
                    break;
                case 3:
                    System.out.println("Dinner Items");
                    System.out.println("1.\t Paav bhaji");
                    break;
                default:
                    System.out.println("No valid option");
            }
        } else {
            System.out.println("Thanks visit again..");
            System.exit(0);
        }
    }
}