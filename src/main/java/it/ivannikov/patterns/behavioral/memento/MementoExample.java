package it.ivannikov.patterns.behavioral.memento;

import java.util.Stack;

//Позволяет сохранять и восстанавливать предыдущее состояние объекта.

// Originator (создает и восстанавливает свое состояние из Memento)
class Editor {
    private String content;

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    // Создает Memento с текущим состоянием
    public EditorMemento save() {
        return new EditorMemento(content);
    }

    // Восстанавливает состояние из Memento
    public void restore(EditorMemento memento) {
        this.content = memento.getSavedContent();
    }
}

// Memento (хранит состояние)
class EditorMemento {
    private final String content;

    public EditorMemento(String content) {
        this.content = content;
    }

    public String getSavedContent() {
        return content;
    }
}

// Caretaker (управляет Memento)
class History {
    private final Stack<EditorMemento> mementos = new Stack<>();

    public void push(EditorMemento memento) {
        mementos.push(memento);
    }

    public EditorMemento pop() {
        return mementos.pop();
    }
}

// Пример использования
public class MementoExample {
    public static void main(String[] args) {
        Editor editor = new Editor();
        History history = new History();

        editor.setContent("First version");
        history.push(editor.save()); // Сохраняем состояние

        editor.setContent("Second version");
        history.push(editor.save()); // Сохраняем состояние

        editor.setContent("Third version");
        System.out.println("Current content: " + editor.getContent()); // Third version

        editor.restore(history.pop()); // Откатываем на Second version
        System.out.println("After undo: " + editor.getContent()); // Second version

        editor.restore(history.pop()); // Откатываем на First version
        System.out.println("After another undo: " + editor.getContent()); // First version
    }
}