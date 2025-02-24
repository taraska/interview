package us.ivannikov.algo.strings;

import java.util.ArrayList;
import java.util.List;

/*
Given a string (e.g., "abc"), return all possible permutations of its characters:

Input: "abc"

Output: ["abc", "acb", "bac", "bca", "cab", "cba"]

Time Complexity:

O(n!) where n is string length

For "abc" (n=3) → 6 permutations

For "abcd" (n=4) → 24 permutations


Как это работает?
Рекурсивный подход:

- Фиксируем первый символ

- Рекурсивно находим перестановки для оставшихся символов

- Меняем первый символ местами с каждым из последующих



//for first:
abc
acb
bac
bca
cba
cab

//second test:
abcd
abdc
acbd
acdb
adcb
adbc
bacd
badc
bcad
bcda
bdca
bdac
cbad
cbda
cabd
cadb
cdab
cdba
dbca
dbac
dcba
dcab
dacb
dabc

 * */
public class PermutationString {
    public static void main(String[] args) {
        PermutationString permutationString = new PermutationString();
        List<String> abc = permutationString.permute("abc");
        List<String> strings = permutationString.permuteTwo("abc");

        abc.stream().forEach(System.out::println);
        System.out.println("___");
        strings.stream().forEach(System.out::println);
        System.out.println("___");
        List<String> abcd = permutationString.permute("abcd");
        abcd.stream().forEach(System.out::println);
    }

    public List<String> permute(String s) {
        List<String> result = new ArrayList<>();
        backtrack(s.toCharArray(), 0, result);
        return result;
    }

    private void backtrack(char[] arr, int start, List<String> result) {
        if (start == arr.length - 1) {
            result.add(new String(arr));
            return;
        }

        for (int i = start; i < arr.length; i++) {
            swap(arr, start, i);
            backtrack(arr, start + 1, result);
            swap(arr, start, i); // backtrack
        }
    }

    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public List<String> permuteTwo(String s) {
        List<String> result = new ArrayList<>();
        heapPermutation(s.toCharArray(), s.length(), result);
        return result;
    }

    void heapPermutation(char[] a, int size, List<String> result) {
        if (size == 1) {
            result.add(new String(a));
            return;
        }

        for (int i = 0; i < size; i++) {
            heapPermutation(a, size-1, result);
            // Odd vs even size handling
            if (size % 2 == 1) swap(a, 0, size-1);
            else swap(a, i, size-1);
        }
    }
}
