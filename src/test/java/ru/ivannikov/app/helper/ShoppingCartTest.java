package ru.ivannikov.app.helper;

import org.junit.jupiter.api.Test;
import ru.ivannikov.app.domain.DisplayProduct;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ShoppingCartTest {

    @Test
    public void shouldReturnShoppingCart() {
        assertThat(ShoppingCart.getInstance().getName()).isEqualTo("cart");
    }

    @Test
    public void shouldReturnSameObject() {
        DisplayProduct displayProduct = new DisplayProduct(100, "display Samsung", "Samsung V101");
        ShoppingCart.getInstance().add(displayProduct);
        assertThat(ShoppingCart.getInstance().getProducts().get(0)).isEqualTo(displayProduct);
    }
}
