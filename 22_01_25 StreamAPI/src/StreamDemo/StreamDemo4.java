package StreamDemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo4 {

    public static void main(String[] args) {
        String[] menuItemNames = {"Sandwitch","Burger","Vada Pav","Idli"};
        System.out.println(Stream.of(menuItemNames));
        System.out.println(Stream.of("Kolkatta","Delhi","Pune"));
        List<String> menuItem= new ArrayList<>(List.of(menuItemNames));//Arrays.asList(menuItemNames);
        menuItem.stream().forEach(e-> System.out.println(e));
        Arrays.stream(menuItemNames);
        Stream.of("Hello","welcome","Java","PHP").forEach(e->System.out.println(e));
        Stream<Integer> stream= Arrays.asList(2,7,8,4,3).stream();
        System.out.println(stream.getClass().getName());
        // List<Integer>list= stream.toList();

        Set<Integer> set=stream.collect(Collectors.toSet());
        System.out.println(set.getClass().getName());
        List <Integer> x =Arrays.asList(5,6,8,3,2);
        List <Integer> triple;
        triple = x.stream()
                .map(i->i*3)
                .collect(Collectors.toList());
        System.out.println(triple);

    }

}

