package us.ivannikov.algo.arrays;

import java.util.Arrays;

/*

Counting Quadruplets with Sum K in Java (LeetCode-style Problem)
Here's a Java solution to count all unique quadruplets in an array
that sum up to a target value K, similar to LeetCode problems like "4Sum":

Given an array of integers nums and an integer K, return the number of unique quadruplets [nums[i], nums[j], nums[k], nums[l]] such that:

i < j < k < l

nums[i] + nums[j] + nums[k] + nums[l] == K


* */

public class QuadrupletSum {
    public int countQuadruplets(int[] nums, int K) {
        Arrays.sort(nums);  // Сортируем массив для удобства
        int n = nums.length;
        int count = 0;

        for (int i = 0; i < n - 3; i++) {
            // Пропускаем дубликаты для первого числа
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            for (int j = i + 1; j < n - 2; j++) {
                // Пропускаем дубликаты для второго числа
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                int left = j + 1;    // Третий элемент
                int right = n - 1;   // Четвертый элемент

                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];

                    if (sum == K) {
                        count++;
                        // Пропускаем дубликаты для третьего числа
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        // Пропускаем дубликаты для четвертого числа
                        while (left < right && nums[right] == nums[right - 1]) right--;
                        left++;
                        right--;
                    } else if (sum < K) {
                        left++;  // Сумма слишком мала - двигаем левый указатель
                    } else {
                        right--; // Сумма слишком велика - двигаем правый указатель
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        QuadrupletSum solution = new QuadrupletSum();
        int[] nums = {1, 0, -1, 0, -2, 2};
        int K = 0;
        System.out.println(solution.countQuadruplets(nums, K)); // Output: 3
    }
    /*
Для массива [1, 0, -1, 0, -2, 2] и K = 0:

После сортировки: [-2, -1, 0, 0, 1, 2]

Найденные четверки:

[-2, -1, 1, 2]

[-2, 0, 0, 2]

[-1, 0, 0, 1]

Результат: 3
    * */
}
