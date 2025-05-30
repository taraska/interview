package us.ivannikov.algo.arrays;

import java.util.Arrays;

public class CoinChange {
    public static int minCoins(int[] coins, int amount) {
        // Create a DP array where dp[i] stores minimum coins for amount i
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1); // Initialize with a value larger than maximum possible
        dp[0] = 0; // Base case: 0 coins needed for amount 0

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println("Minimum coins needed: " + minCoins(coins, amount)); // Output: 3
        System.out.println("Minimum coins needed: " + copyCoin(coins, amount)); // Output: 3
        System.out.println("Minimum coins needed: " + copyOneMoreChange(coins, amount)); // Output: 3
    }


    public static int copyOneMoreChange(int[] coins, int amount) {
        int[] arr = new int[amount + 1];
        Arrays.fill(arr, amount + 1);
        arr[0] = 0;

        for (int i = 0; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    arr[i] = Math.min(arr[i], arr[i - coin] + 1);
                }
            }
        }

        return arr[amount] > amount ? -1 : arr[amount];
    }

    public static int copyCoin(int[] coins, int amount) {
        //create array
        int b[] = new int[amount + 1];
        Arrays.fill(b, amount + 1);

        b[0] = 0;

        for (int i = 0; i <= amount; i++) {
            for (int coin : coins) {
                if (i >= coin) {
                    b[i] = Math.min(b[i], b[i - coin] + 1);
                }
            }
        }

        return b[amount] > amount ? -1 : b[amount];
    }
}
