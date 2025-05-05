package it.ivannikov.patterns.structural.adapter;

//связать классы, которые мало что общего имеют друг с другом, но должны работать
//вместе
interface Ethernet {
    void connectToInternet();
}

class USB {
    public void plugInUSB() {
        System.out.println("USB connected.");
    }
}

class USBToEthernetAdapter implements Ethernet {
    private USB usb;

    public USBToEthernetAdapter(USB usb) {
        this.usb = usb;
    }

    @Override
    public void connectToInternet() {
        usb.plugInUSB();
        System.out.println("Converting USB signal to Ethernet...");
        System.out.println("Internet connected via Ethernet!");
    }
}

public class Main {
    public static void main(String[] args) {
        USB usb = new USB();
        Ethernet ethernetAdapter = new USBToEthernetAdapter(usb);
        ethernetAdapter.connectToInternet();
    }
}
