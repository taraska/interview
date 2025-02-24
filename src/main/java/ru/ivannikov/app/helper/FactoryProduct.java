package ru.ivannikov.app.helper;

import ru.ivannikov.app.domain.Product;

import java.util.List;

public class FactoryProduct {

    private List<Product> productList;

    public FactoryProduct(List<Product> productList) {
        this.productList = productList;
    }

    public Product getProduct(final String name) throws Exception {
        return productList.stream().filter(product -> product.getName().equals(name))
            .findFirst().orElseThrow(() -> new Exception("Product not found!"));
    }
}
