package us.ivannikov.algo.java8;

import java.util.LinkedHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstNonRepeatedCharacter {
    public static Character findFirstNonRepeatedChar(String input) {
        return input.chars()  // Convert to IntStream of characters
            .mapToObj(c -> (char) c)  // Convert to Stream<Character>
            .collect(Collectors.groupingBy(
                Function.identity(),
                LinkedHashMap::new,  // Preserves insertion order
                Collectors.counting()
            ))
            .entrySet()
            .stream()
            .filter(entry -> entry.getValue() == 1L)
            .map(entry -> entry.getKey())
            .findFirst()
            .orElse(null);  // Return null if no non-repeated character found
    }

    public static void main(String[] args) {
        String testString = "swiss";
        Character result = findFirstNonRepeatedChar(testString);
        System.out.println("First non-repeated character: " + result);  // Output: w
    }
}
