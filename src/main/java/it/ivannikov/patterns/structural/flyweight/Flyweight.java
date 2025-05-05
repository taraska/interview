package it.ivannikov.patterns.structural.flyweight;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Этот паттерн позволяет эффективно разделять общее состояние
между множеством объектов, уменьшая потребление памяти.

Пример: Текстовый редактор с разделением символов
Представим, что нам нужно отобразить большой текст, где многие
символы повторяются. Вместо создания отдельного объекта для каждого
символа, мы будем использовать общие объекты для одинаковых символов.
* */
// Внутреннее состояние (разделяемое)
class Character {
    private final char symbol;
    private final String fontFamily;
    private final int size;

    public Character(char symbol, String fontFamily, int size) {
        this.symbol = symbol;
        this.fontFamily = fontFamily;
        this.size = size;
    }

    public void display(int x, int y) {
        System.out.printf("Symbol: %c, Font: %s, Size: %d, Position: (%d, %d)%n",
            symbol, fontFamily, size, x, y);
    }
}

// Фабрика для переиспользования символов
class CharacterFactory {
    private final Map<Character, Character> characters = new HashMap<>();

    public Character getCharacter(char symbol, String fontFamily, int size) {
        Character key = new Character(symbol, fontFamily, size);
        if (!characters.containsKey(key)) {
            characters.put(key, key);
        }
        return characters.get(key);
    }
}

// Внешнее состояние (позиция символов)
class TextEditor {
    private final CharacterFactory factory;
    private final List<Character> characters = new ArrayList<>();
    private final List<Integer> xPositions = new ArrayList<>();
    private final List<Integer> yPositions = new ArrayList<>();

    public TextEditor(CharacterFactory factory) {
        this.factory = factory;
    }

    public void addCharacter(char symbol, String fontFamily, int size, int x, int y) {
        Character character = factory.getCharacter(symbol, fontFamily, size);
        characters.add(character);
        xPositions.add(x);
        yPositions.add(y);
    }

    public void display() {
        for (int i = 0; i < characters.size(); i++) {
            characters.get(i).display(xPositions.get(i), yPositions.get(i));
        }
    }
}

public class Flyweight {
    public static void main(String[] args) {
        CharacterFactory factory = new CharacterFactory();
        TextEditor editor = new TextEditor(factory);

        // Добавляем символы (одинаковые 'A' и 'B' будут переиспользованы)
        editor.addCharacter('A', "Arial", 12, 0, 0);
        editor.addCharacter('B', "Times New Roman", 14, 1, 0);
        editor.addCharacter('A', "Arial", 12, 2, 0); // Переиспользует существующий 'A'
        editor.addCharacter('C', "Verdana", 16, 3, 0);

        // Выводим текст
        editor.display();
    }
}
