package StreamDemo;

import java.util.*;
import java.util.stream.Collectors;

public class StreamExercises {

    public static void main(String[] args) {

        /* ===== BASIC STREAM EXERCISES ===== */

        // 1. Filter Even Numbers
        List<Integer> nums1 = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> evens = nums1.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println(evens);

        // 2. Convert Strings to Uppercase
        List<String> words = Arrays.asList("java", "stream", "api");
        List<String> upper = words.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println(upper);

        // 3. Count Elements Greater Than 10
        List<Integer> nums2 = Arrays.asList(5, 10, 15, 20, 3);
        long count = nums2.stream()
                .filter(n -> n > 10)
                .count();
        System.out.println(count);

        // 4. Sum of All Numbers
        int sum = nums2.stream()
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println(sum);

        // 5. Find First Element
        List<String> names = Arrays.asList("A", "B", "C");
        names.stream()
                .findFirst()
                .ifPresent(System.out::println);

        /* ===== INTERMEDIATE STREAM EXERCISES ===== */

        // 6. Remove Duplicates
        List<Integer> nums3 = Arrays.asList(1, 2, 2, 3, 3, 4);
        List<Integer> distinct = nums3.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println(distinct);

        // 7. Sort Strings by Length
        List<String> items = Arrays.asList("one", "three", "four", "two");
        List<String> sortedByLength = items.stream()
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
        System.out.println(sortedByLength);

        // 8. Find Maximum Number
        nums3.stream()
                .max(Integer::compareTo)
                .ifPresent(System.out::println);

        // 9. Square and Filter (>20)
        List<Integer> nums4 = Arrays.asList(2, 3, 4, 5);
        List<Integer> squaredFiltered = nums4.stream()
                .map(n -> n * n)
                .filter(n -> n > 20)
                .collect(Collectors.toList());
        System.out.println(squaredFiltered);

        // 10. Group Strings by Length
        List<String> groupWords = Arrays.asList("one", "two", "three", "four");
        Map<Integer, List<String>> grouped =
                groupWords.stream()
                        .collect(Collectors.groupingBy(String::length));
        System.out.println(grouped);

        /* ===== INTERMEDIATE+ STREAM EXERCISES ===== */

        // 11. Find Second Highest Number
        List<Integer> nums5 = Arrays.asList(10, 20, 30, 40, 50);
        nums5.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .ifPresent(System.out::println);

        // 12. Join Strings with Comma
        String joined = items.stream()
                .collect(Collectors.joining(","));
        System.out.println(joined);

        // 13. Partition Even and Odd Numbers
        Map<Boolean, List<Integer>> partitioned =
                nums1.stream()
                        .collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println(partitioned);
    }
}

