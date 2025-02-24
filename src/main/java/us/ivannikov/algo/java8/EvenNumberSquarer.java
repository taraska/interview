package us.ivannikov.algo.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class EvenNumberSquarer {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> squaredEvens = numbers.stream()
            .filter(n -> n % 2 == 0)       // Filter even numbers
            .map(n -> n * n)               // Square each number
            .collect(Collectors.toList());  // Collect results to a list

        System.out.println(squaredEvens);   // Output: [4, 16, 36, 64, 100]

        int[] squaredEvens1 = IntStream.rangeClosed(1, 10)
            .filter(n -> n % 2 == 0)
            .map(n -> n * n)
            .toArray();  // Results in int[] instead of List<Integer>

        System.out.println(Arrays.toString(squaredEvens1)); //[4, 16, 36, 64, 100]
    }
}
