package it.ivannikov.patterns.behavioral.visitor;

import com.fasterxml.jackson.databind.util.JSONPObject;

/*
Определение: Добавляет новые операции к объектам без изменения их классов.
Пример: Сериализация объектов.
* */
interface Visitor {
    void visit(XmlElement xml);

    void visit(JSONPObject json);
}

interface Element {
    void accept(Visitor visitor);
}

class XmlElement implements Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class VisitorImpl implements Visitor {
    @Override
    public void visit(XmlElement xml) {
        System.out.println("Обработка XML");
    }

    @Override
    public void visit(JSONPObject json) {
        System.out.println("Обработка JSON");
    }
}


public class Main {
    public static void main(String[] args) {
        // Использование:
        Element element = new XmlElement();
        element.accept(new VisitorImpl()); // Обработка XML
    }
}
