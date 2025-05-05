package it.ivannikov.patterns.behavioral.iterator;

import java.util.Iterator;

//Предоставляет способ последовательного доступа к элементам коллекции.

// Коллекция, поддерживающая итерацию
class BookCollection implements Iterable<String> {
    private final String[] books;

    public BookCollection(String[] books) {
        this.books = books;
    }

    @Override
    public Iterator<String> iterator() {
        return new BookIterator();
    }

    // Внутренний итератор
    private class BookIterator implements Iterator<String> {
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < books.length;
        }

        @Override
        public String next() {
            return books[index++];
        }
    }
}

// Пример использования
public class IteratorExample {
    public static void main(String[] args) {
        String[] books = {"Book 1", "Book 2", "Book 3"};
        BookCollection collection = new BookCollection(books);

        // Используем foreach (т.к. BookCollection реализует Iterable)
        for (String book : collection) {
            System.out.println(book);
        }
    }
}
