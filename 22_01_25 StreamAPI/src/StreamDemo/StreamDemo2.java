package StreamDemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamDemo2 {
    public static void main(String[] args) {
        String[] menuItemNames = {"Sandwitch","Burger","Vada Pav","Idli"};
        System.out.println(Stream.of(menuItemNames));
        System.out.println(Stream.of("Kolkatta","Delhi","Pune"));
        List<String> menuItem= new ArrayList<>(List.of(menuItemNames));//Arrays.asList(menuItemNames);
        menuItem.stream().forEach(e-> System.out.println(e));
        Arrays.stream(menuItemNames);
        Stream.of("Hello","welcome","Java").forEach(s-> System.out.println(s));

    }

}
 