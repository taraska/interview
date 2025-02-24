package ru.ivannikov.app.domain;

import java.util.List;

public record Order(int id, User user, List<Product> productList) { }
