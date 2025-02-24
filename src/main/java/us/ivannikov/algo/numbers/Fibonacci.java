package us.ivannikov.algo.numbers;

import java.util.stream.Stream;

public class Fibonacci {
    public static void main(String[] args) {
        //вычислить первые 7 чисел фибоначи через рекурсию

        int fi = f(7); //0 //1 //1 //2 //3 //5 //8
        System.out.println(fi); //8

        //через Stream

        int num = 7;
        Stream.iterate(new int[]{0, 1}, arr -> new int[]{arr[1], arr[0] + arr[1]})
            //Задаём лимит значений:
            .limit(num)
            //Отбираем по первому элементу каждого массива:
            .map(y -> y[0])
            //Выводим в консоль:
            .forEach(x -> System.out.print(x)); //0112358

        // Given Number N
        int N = 10;

        // Function Call
        Fibonacci(N); //0 1 1 2 3 5 8 13 21 34

        System.out.println("____");
        long l = altFib(N);
        System.out.println(l);

        long l1 = Fibonacci.fibonacciMemoization(N); //O(n^2)
        System.out.println(l1); //55
    }

    public static int f(int n) {

        if (n <= 1) {
            return 0;
        }

        if (n == 2) {
            return 1;
        }

        return f(n - 1) + f(n - 2);
    }

    // Optimized recursive method with memoization
    private static long[] memo;

    public static long fibonacciMemoization(int n) {
        memo = new long[n + 1];
        return fibMemoHelper(n);
    }

    private static long fibMemoHelper(int n) {
        if (n <= 1) {
            return n;
        }
        if (memo[n] != 0) {
            return memo[n];
        }
        memo[n] = fibMemoHelper(n - 1) + fibMemoHelper(n - 2);
        return memo[n];
    }

    static void Fibonacci(int N) {
        int num1 = 0, num2 = 1;

        for (int i = 0; i < N; i++) {
            // Print the number
            System.out.print(num1 + " ");

            // Swap
            int num3 = num2 + num1;
            num1 = num2;
            num2 = num3;
        }
    }


    public static long altFib(int n) {
        long i = 0;
        long b = 1;
        long c = 0;

        for (int j = 0; j < n - 2; j++) {
            c = i + b;
            System.out.println(c);
            i = b;
            b = c;
        }

        return b;
    }
}
