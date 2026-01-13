package fundamental;

import java.util.Scanner;

public class square {
    public static void main(String [] args){
        System.out.println("Enter the Number for Square : ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("The Square of Given Number is : "+n*n);
    }
}
