package it.ivannikov.patterns.creational.factoryPattern;

/*
 *
Key Characteristics:
Defines an interface for creating an object

Lets subclasses decide which class to instantiate

Promotes loose coupling by eliminating the need to bind application-specific classes into the code
 * */
// Product interface
interface Vehicle {
    void drive();
}

// Concrete products
class Car implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Driving a car...");
    }
}

class Bike implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Riding a bike...");
    }
}

// Factory class
class VehicleFactory {
    public Vehicle createVehicle(String type) {
        if (type.equalsIgnoreCase("car")) {
            return new Car();
        } else if (type.equalsIgnoreCase("bike")) {
            return new Bike();
        }
        return null;
    }
}

// Client code
public class Main {
    public static void main(String[] args) {
        VehicleFactory factory = new VehicleFactory();

        Vehicle car = factory.createVehicle("car");
        car.drive();  // Output: Driving a car...

        Vehicle bike = factory.createVehicle("bike");
        bike.drive(); // Output: Riding a bike...
    }
}
