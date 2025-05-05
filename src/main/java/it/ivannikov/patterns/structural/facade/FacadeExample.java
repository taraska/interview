package it.ivannikov.patterns.structural.facade;

//Предоставляет простой интерфейс к сложной системе.
// Сложные подсистемы
class CPU {
    void start() {
        System.out.println("CPU started");
    }
}

class Memory {
    void load() {
        System.out.println("Memory loaded");
    }
}

class HardDrive {
    void read() {
        System.out.println("HardDrive read");
    }
}

// Фасад (упрощенный интерфейс)
class ComputerFacade {
    private final CPU cpu;
    private final Memory memory;
    private final HardDrive hardDrive;

    public ComputerFacade() {
        this.cpu = new CPU();
        this.memory = new Memory();
        this.hardDrive = new HardDrive();
    }

    public void start() {
        cpu.start();
        memory.load();
        hardDrive.read();
        System.out.println("Computer started!");
    }
}

// Пример использования
public class FacadeExample {
    public static void main(String[] args) {
        ComputerFacade computer = new ComputerFacade();
        computer.start();
    }
}
