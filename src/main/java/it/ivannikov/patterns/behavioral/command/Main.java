package it.ivannikov.patterns.behavioral.command;

/*
Определение: Инкапсулирует запрос в виде объекта,
позволяя параметризовать клиенты с разными запросами.
Пример: Управление действиями кнопок.
* */

class Light {
    void turnOn() {
        System.out.println("light");
    }
}

interface Command {
    void execute();
}

class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }
}

class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }
}


public class Main {
    public static void main(String[] args) {
        // Использование:
        RemoteControl remote = new RemoteControl();
        Light light = new Light();
        remote.setCommand(new LightOnCommand(light));
        remote.pressButton(); // Включает свет
    }
}
