package us.ivannikov.algo.numbers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class FactorialFromTo {

    //Требуется посчитать сумму целых чисел, расположенных между числами 1 и N включительно.
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader("input.txt")))) {
            PrintWriter printWriter = new PrintWriter(new FileWriter("output.txt"));
            int N = scanner.nextInt();
            long bigInteger;
            if (N <= 0) {
                bigInteger = (2 - N) * (N + 1) / 2;
            } else {
                //формула арифметической прогрессии
                bigInteger = N * (N + 1) / 2;
            }

            if (N <= 0) {
                printWriter.println(bigInteger);
            } else {
                printWriter.println(bigInteger);
            }
            printWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
