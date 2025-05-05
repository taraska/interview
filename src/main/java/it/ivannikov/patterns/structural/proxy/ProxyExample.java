package it.ivannikov.patterns.structural.proxy;

//Контролирует доступ к объекту,
// добавляя дополнительную логику (ленивая загрузка, кэширование и т. д.).
// Интерфейс реального объекта
interface Image {
    void display();
}

// Реальный объект (тяжелый для создания)
class RealImage implements Image {
    private final String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadFromDisk();
    }

    private void loadFromDisk() {
        System.out.println("Loading image: " + filename);
    }

    @Override
    public void display() {
        System.out.println("Displaying image: " + filename);
    }
}

// Прокси (ленивая загрузка)
class ProxyImage implements Image {
    private RealImage realImage;
    private final String filename;

    public ProxyImage(String filename) {
        this.filename = filename;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(filename);
        }
        realImage.display();
    }
}

// Пример использования
public class ProxyExample {
    public static void main(String[] args) {
        Image image = new ProxyImage("large_image.jpg");

        // RealImage загружается только при вызове display()
        image.display();
        image.display(); // Повторный вызов использует уже загруженный объект
    }
}
