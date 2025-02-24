package us.ivannikov.algo.arrays;

import java.util.HashSet;
import java.util.Set;

public class DuplicatesInArrayHashSet {

    public static void main(String[] args) {
        //O(n) - time complexity
        int[] numbers = {1, 2, 3, 4, 5, 2, 7, 8, 8, 9};
        Set<Integer> uniqueNumbers = new HashSet<>();
        Set<Integer> duplicates = new HashSet<>();

        for (int num : numbers) {
            if (!uniqueNumbers.add(num)) { // If add() returns false, the element is a duplicate
                duplicates.add(num);
            }
        }

        System.out.println("Duplicate elements: " + duplicates);  //Duplicate elements: [2, 8]
    }
}
