import com.sun.jdi.Value;

import javax.xml.validation.Validator;
import java.util.Optional;

import static java.lang.Character.getName;
import static java.sql.DriverManager.println;

public class OptionalDemo {
    String name;
    public OptionalDemo(String name)
    {
        this.name=name;
    }
    public static String getName(String name)
    {
        return name;
    }
    public static void main(String[] args) {
        //instead of throwing null pointer exception we can use optional
        Optional <String> opt1=Optional.of("Some value");
        //the value should not be null
        Optional<String>opt2=Optional.ofNullable(null);
        //this means null is allowed
        Optional<String> opt3=Optional.empty();
        //no value in object container is allowed.
        System.out.println(opt2);
        if(opt1.isPresent())
        {
            System.out.println(opt1.get());
        }
        opt1.ifPresent(value-> System.out.println(value));
        String timeout = System.getenv("TIMEOUT");
        int value = timeout != null ? Integer.parseInt(timeout):30;
        System.out.println(value);
        Optional.ofNullable(System.getenv("TIMEOUT"))
                .map(Integer::parseInt)
                .orElse(30);

    }
}
