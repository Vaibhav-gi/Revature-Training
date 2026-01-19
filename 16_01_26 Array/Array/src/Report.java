import java.util.Scanner;

public class Report {
    public static void main(String[] args) {
        System.out.println("id \t\t Name\t\t HindiMarks \t\t English Marks\t\t Maths Marks\t\t Total");
//        System.out.println("1 \t\t  Hari\t\t 78 \t\t\t\t\t 80 \t\t\t\t  85\t\t\t\t ");
        System.out.println("Enter the limit of an array");
        int limit = new Scanner(System.in).nextInt();
        String st_name[] = new String[limit];
        int Hmarks[] = new int[limit];
        int Emarks[] = new int[limit];
        int Mmarks[] = new int[limit];
        for (int i = 0; i < limit; i++) {
            System.out.println("Enter name of student");
            st_name[i] = new Scanner(System.in).next();
            System.out.println("Enter Hindi marks");
            Hmarks[i] = new Scanner(System.in).nextInt();
            System.out.println("Enter English marks");
            Emarks[i] = new Scanner(System.in).nextInt();
            System.out.println("Enter Maths marks");
            Mmarks[i] = new Scanner(System.in).nextInt();
        }
        for (int i = 0; i < limit; i++) {
            System.out.println("1 \t\t " + st_name[i] +
                    "\t\t\t" + Hmarks[i]
                    + "\t\t\t" + Emarks[i]
                    + "\t\t\t" + Mmarks[i]
                    + "\t\t\t" + (Hmarks[i]+Emarks[i]+Mmarks[i]));
        }

    }
}
 