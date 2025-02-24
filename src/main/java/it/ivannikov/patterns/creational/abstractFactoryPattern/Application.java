package it.ivannikov.patterns.creational.abstractFactoryPattern;

/*
Key Characteristics:
Creates families of related objects

Higher level of abstraction than Factory Pattern

Useful when a system needs to be independent of how its products are created
 * */

// Abstract products
interface Button {
    void render();
}

interface Checkbox {
    void render();
}

// Concrete products for Windows
class WindowsButton implements Button {
    @Override
    public void render() {
        System.out.println("Rendering a Windows button");
    }
}

class WindowsCheckbox implements Checkbox {
    @Override
    public void render() {
        System.out.println("Rendering a Windows checkbox");
    }
}

// Concrete products for Mac
class MacButton implements Button {
    @Override
    public void render() {
        System.out.println("Rendering a Mac button");
    }
}

class MacCheckbox implements Checkbox {
    @Override
    public void render() {
        System.out.println("Rendering a Mac checkbox");
    }
}

// Abstract factory
interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}

// Concrete factories
class WindowsFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}

class MacFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacCheckbox();
    }
}

// Client code
public class Application {
    private Button button;
    private Checkbox checkbox;

    public Application(GUIFactory factory) {
        button = factory.createButton();
        checkbox = factory.createCheckbox();
    }

    public void render() {
        button.render();
        checkbox.render();
    }

    public static void main(String[] args) {
        // Create a Windows application
        Application windowsApp = new Application(new WindowsFactory());
        windowsApp.render();
        // Output:
        // Rendering a Windows button
        // Rendering a Windows checkbox

        // Create a Mac application
        Application macApp = new Application(new MacFactory());
        macApp.render();
        // Output:
        // Rendering a Mac button
        // Rendering a Mac checkbox
    }
}
