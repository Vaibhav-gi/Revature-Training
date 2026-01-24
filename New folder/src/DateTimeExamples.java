import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class DateTimeExamples {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        System.out.println(today);
        LocalDate dob = LocalDate.of(2002, 5, 6);
        System.out.println(dob);
        Period period = Period.between(dob, today);
        int age = period.getYears();
        System.out.println("Age = "+age +" Years");

        LocalDate nextweek = today.plusWeeks(1);
        System.out.println(nextweek);
        LocalTime now = LocalTime.now();
        LocalTime meeting = LocalTime.of(11,30);
        System.out.println(now);
        System.out.println(meeting);
        ZonedDateTime indianTime = ZonedDateTime.now(ZoneId.of("India/Kolkata"));
        System.out.println(indianTime);
        ZonedDateTime usTime= ZonedDateTime.now(ZoneId.of("America/USA"));
        System.out.println(usTime);
        Instant nowq = Instant.now();
        System.out.println(nowq);

        DateTimeFormatter formatter= DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        String formatted = LocalDateTime.now().format(formatter);
        System.out.println(formatted);

        Scanner sc = new Scanner(System.in).reset();
    }
}
