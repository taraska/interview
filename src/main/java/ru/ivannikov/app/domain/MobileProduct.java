package ru.ivannikov.app.domain;

public record MobileProduct(int price, String name, String description) implements Product {
    @Override
    public String getName() {
        return name;
    }
}
