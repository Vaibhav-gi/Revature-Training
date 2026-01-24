import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Person {

    private String name ="Chintan";
    private void greet()
    {
        System.out.println("Hello"+ name);
    }

    public static void main(String[] args) throws Exception{
        Person person=new Person();
        Class<?> cla=person.getClass();
        Field name=cla.getDeclaredField("name");
        name.setAccessible(true);
        name.set(person,"Swami");
        Method greet=cla.getDeclaredMethod("greet");
        greet.setAccessible(true);
        greet.invoke(person);

    }

}
