package it.ivannikov.patterns.structural.bridge;

//Разделяет абстракцию и реализацию, позволяя им изменяться независимо.
// Реализация (интерфейс)
interface Device {
    void enable();
    void disable();
    boolean isEnabled();
}

// Конкретные реализации
class TV implements Device {
    private boolean on = false;

    @Override
    public void enable() {
        on = true;
        System.out.println("TV is ON");
    }

    @Override
    public void disable() {
        on = false;
        System.out.println("TV is OFF");
    }

    @Override
    public boolean isEnabled() {
        return on;
    }
}

class Radio implements Device {
    private boolean on = false;

    @Override
    public void enable() {
        on = true;
        System.out.println("Radio is ON");
    }

    @Override
    public void disable() {
        on = false;
        System.out.println("Radio is OFF");
    }

    @Override
    public boolean isEnabled() {
        return on;
    }
}

// Абстракция (управление устройством)
abstract class RemoteControl {
    protected Device device;

    public RemoteControl(Device device) {
        this.device = device;
    }

    abstract void togglePower();
}

// Улучшенный пульт
class AdvancedRemote extends RemoteControl {
    public AdvancedRemote(Device device) {
        super(device);
    }

    @Override
    void togglePower() {
        if (device.isEnabled()) {
            device.disable();
        } else {
            device.enable();
        }
    }

    void mute() {
        System.out.println("Muting device");
    }
}

// Пример использования
public class BridgeExample {
    public static void main(String[] args) {
        Device tv = new TV();
        RemoteControl remote = new AdvancedRemote(tv);

        remote.togglePower(); // TV is ON
        remote.togglePower(); // TV is OFF

        Device radio = new Radio();
        AdvancedRemote advancedRemote = new AdvancedRemote(radio);
        advancedRemote.togglePower(); // Radio is ON
        advancedRemote.mute(); // Muting device
    }
}
