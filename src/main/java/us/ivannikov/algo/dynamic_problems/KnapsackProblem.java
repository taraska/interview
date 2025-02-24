package us.ivannikov.algo.dynamic_problems;


import java.util.ArrayList;
import java.util.List;

/*
 Задача о рюкзаке (Knapsack problem) - это классическая задача комбинаторной оптимизации.
 Дано множество предметов, каждый с определенным весом и ценностью. Нужно определить,
 какие предметы положить в рюкзак ограниченной вместимости, чтобы суммарная ценность была максимальной.
 * */
public class KnapsackProblem {
    public static void main(String[] args) {
        int[] weights = {2, 3, 4, 5};
        int[] values = {3, 4, 5, 6};
        String[] items = {"Книга", "Ноутбук", "Фонарик", "Котелок"};
        int capacity = 5;

        Result result = knapsack(weights, values, items, capacity);

        System.out.println("Максимальная ценность: " + result.maxValue);
        System.out.println("Выбранные предметы: " + result.selectedItems);

        /*
        Максимальная ценность: 7
        Выбранные предметы: [Ноутбук, Книга]
        * */
    }

    public static class Result {
        int maxValue;
        List<String> selectedItems;

        public Result(int maxValue, List<String> selectedItems) {
            this.maxValue = maxValue;
            this.selectedItems = selectedItems;
        }
    }

    public static Result knapsack(int[] weights, int[] values, String[] items, int capacity) {
        int n = weights.length;
        int[][] dp = new int[n + 1][capacity + 1];

        // Заполняем таблицу dp
        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= capacity; w++) {
                if (weights[i - 1] <= w) {
                    dp[i][w] = Math.max(
                        values[i - 1] + dp[i - 1][w - weights[i - 1]],
                        dp[i - 1][w]
                    );
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        // Восстанавливаем выбранные предметы
        List<String> selectedItems = new ArrayList<>();
        int w = capacity;
        for (int i = n; i > 0; i--) {
            if (dp[i][w] != dp[i - 1][w]) {
                selectedItems.add(items[i - 1]);
                w -= weights[i - 1];
            }
        }

        return new Result(dp[n][capacity], selectedItems);
    }
}

