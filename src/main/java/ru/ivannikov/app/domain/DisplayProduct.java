package ru.ivannikov.app.domain;

public record DisplayProduct(int price, String description, String name) implements Product {
    @Override
    public String getName() {
        return name;
    }
}