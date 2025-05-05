package it.ivannikov.patterns.creational.singleton;

//Гарантирует, что у класса есть только один экземпляр,
//и предоставляет глобальную точку доступа к нему.
// Пример использования
public class SingletonExample {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        singleton.showMessage(); // Hello from Singleton!
    }
}
