package fundamental;

import java.util.Scanner;

public class areaOfCircle {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the radius of circle: ");
        int r = sc.nextInt();
        double pi = 3.14;
        System.out.println("The area of circle "+ pi*r*r);
    }
}
