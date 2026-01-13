package fundamental;

import java.util.Scanner;

public class greatestOfTwo {
    public static void main(String[] args){
        System.out.println("Enter the numbers : ");
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        if(n1 > n2){
            System.out.println(n1+" is greatest number.");
        }
        else {
            System.out.println(n2+" is greatest number.");

        }
    }
}
