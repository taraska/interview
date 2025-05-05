package it.ivannikov.patterns.behavioral.strategy;

import java.util.Arrays;
import java.util.List;

/*
Определение: Позволяет выбирать алгоритм во время выполнения,
инкапсулируя их в отдельные классы.

Пример: Сортировка списка разными алгоритмами.
*
* */

interface SortStrategy {
    void sort(List<Integer> list);
}

class BubbleSort implements SortStrategy {
    @Override
    public void sort(List<Integer> list) {
        System.out.println("Сортировка пузырьком");
        // Реализация
    }
}

class QuickSort implements SortStrategy {
    @Override
    public void sort(List<Integer> list) {
        System.out.println("Быстрая сортировка");
        // Реализация
    }
}

class Sorter {
    private SortStrategy strategy;

    public void setStrategy(SortStrategy strategy) {
        this.strategy = strategy;
    }

    public void executeSort(List<Integer> list) {
        strategy.sort(list);
    }
}
public class Main {
    public static void main(String[] args) {
        // Использование:
        Sorter sorter = new Sorter();
        sorter.setStrategy(new BubbleSort());
        sorter.executeSort(Arrays.asList(5, 2, 9));
    }
}
