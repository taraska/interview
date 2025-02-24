package us.ivannikov.algo.arrays;

import java.util.Arrays;

/*
 * finding the maximum product of two numbers in an array containing both positive and negative numbers.
 * */
public class FindMaxNegativeAndPositive {
    public static int findMaxProduct(int[] nums) {
        if (nums == null || nums.length < 2) {
            throw new IllegalArgumentException("Массив должен содержать как минимум два числа.");
        }

        // Сортируем массив
        Arrays.sort(nums);

        int n = nums.length;

        // Произведение двух наибольших чисел
        int product1 = nums[n - 1] * nums[n - 2];

        // Произведение двух наименьших чисел (если оба отрицательные)
        int product2 = nums[0] * nums[1];

        // Возвращаем максимальное из двух произведений
        return Math.max(product1, product2);
    }

    public static void main(String[] args) {
        int[] nums = {-10, -3, 5, 2};
        System.out.println("Максимальное произведение: " + findMaxProduct(nums)); // Вывод: 30
    }
}
