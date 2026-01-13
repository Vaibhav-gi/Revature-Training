package fundamental;

import java.util.Scanner;

public class addition {
    public static int Add(int x, int y){
        return x + y;
    }
    public static int Sub(int x, int y){
        return x - y;
    }
    public static void main(String[] args)
    {
        System.out.println("Enter two numbers: ");
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        System.out.println("The addition of two numbers : "+Add(num1, num2));
        System.out.println("The subtraction of two numbers : "+Sub(num1, num2));
    }
}
