package it.ivannikov.patterns.creational.prototype;

import java.util.HashMap;
import java.util.Map;

//Позволяет копировать объекты без привязки к их конкретным классам.
// Интерфейс прототипа
interface Prototype extends Cloneable {
    Prototype clone();
}

// Конкретный класс, реализующий Prototype
class Car implements Prototype {
    private String model;

    public Car(String model) {
        this.model = model;
    }

    @Override
    public Prototype clone() {
        return new Car(this.model); // Глубокая копия
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}

// Менеджер прототипов (хранит готовые клоны)
class PrototypeManager {
    private static final Map<String, Prototype> prototypes = new HashMap<>();

    static {
        prototypes.put("sedan", new Car("Toyota Camry"));
        prototypes.put("suv", new Car("Honda CR-V"));
    }

    public static Prototype getPrototype(String type) {
        return prototypes.get(type).clone();
    }
}

// Пример использования
public class PrototypeExample {
    public static void main(String[] args) {
        Prototype sedan = PrototypeManager.getPrototype("sedan");
        Prototype suv = PrototypeManager.getPrototype("suv");

        System.out.println(((Car) sedan).getModel()); // Toyota Camry
        System.out.println(((Car) suv).getModel());  // Honda CR-V
    }
}