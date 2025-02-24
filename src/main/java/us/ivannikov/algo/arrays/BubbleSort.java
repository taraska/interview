package us.ivannikov.algo.arrays;

import java.util.Arrays;

public class BubbleSort {

    //O(n^2)
    public static void main(String[] args) {
        int[] array = new int[]{1, 5, 2, 10, 99, 2};

        Arrays.sort(array);

        System.out.println(Arrays.toString(array));

        array = new int[]{1, 5, 2, 10, 99, 2};

        for (int i = 0; i < array.length; i++) {
            for (int n = 0; n < array.length - 1; n++) {
                if (array[n] > array[n + 1]) {
                    int j = array[n + 1];
                    array[n + 1] = array[n];
                    array[n] = j;
                }
            }
        }

        System.out.println(Arrays.toString(array)); //[1, 2, 2, 5, 10, 99]
    }
}
