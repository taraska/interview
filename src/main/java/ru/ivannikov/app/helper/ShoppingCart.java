package ru.ivannikov.app.helper;

import ru.ivannikov.app.domain.Product;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private static ShoppingCart shoppingCart;
    private static final Object object = new Object();
    private static final String name = "cart";
    private List<Product> products = new ArrayList<>();

    private ShoppingCart() {
    }

    public static ShoppingCart getInstance() {
        if (shoppingCart == null) {
            synchronized (object) {
                if (shoppingCart == null) {
                    shoppingCart = new ShoppingCart();
                }
            }
        }

        return shoppingCart;
    }

    public String getName() {
        return ShoppingCart.name;
    }

    public void add(Product product) {
        products.add(product);
    }

    public List<Product> getProducts() {
        return products;
    }
}
