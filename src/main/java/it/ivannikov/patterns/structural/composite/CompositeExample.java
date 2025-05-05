package it.ivannikov.patterns.structural.composite;

import java.util.ArrayList;
import java.util.List;

//Позволяет работать с древовидной структурой объектов как с единым целым.
// Компонент (общий интерфейс)
interface FileSystemComponent {
    void showDetails();
}

// Лист (файл)
class File implements FileSystemComponent {
    private final String name;

    public File(String name) {
        this.name = name;
    }

    @Override
    public void showDetails() {
        System.out.println("File: " + name);
    }
}

// Композит (папка)
class Directory implements FileSystemComponent {
    private final String name;
    private final List<FileSystemComponent> components = new ArrayList<>();

    public Directory(String name) {
        this.name = name;
    }

    public void addComponent(FileSystemComponent component) {
        components.add(component);
    }

    @Override
    public void showDetails() {
        System.out.println("Directory: " + name);
        for (FileSystemComponent component : components) {
            component.showDetails();
        }
    }
}

// Пример использования
public class CompositeExample {
    public static void main(String[] args) {
        FileSystemComponent file1 = new File("document.txt");
        FileSystemComponent file2 = new File("image.jpg");

        Directory root = new Directory("Root");
        Directory folder1 = new Directory("Folder1");

        root.addComponent(file1);
        root.addComponent(folder1);
        folder1.addComponent(file2);

        root.showDetails();
    }
}
