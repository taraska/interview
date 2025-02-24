package ru.ivannikov.app.helper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.ivannikov.app.domain.DisplayProduct;
import ru.ivannikov.app.domain.MobileProduct;
import ru.ivannikov.app.domain.Product;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FactoryProductTest {

    private List<Product> list = new ArrayList<>();
    private FactoryProduct factoryProduct;

    @BeforeEach
    public void setUp() {
        list.clear();
        list.add(new MobileProduct(100, "mobile", "description"));
        list.add(new DisplayProduct(150, "phone", "description hello"));
        factoryProduct = new FactoryProduct(list);
    }

    @Test
    public void shouldReturnMobileProduct() throws Exception {
        final Product product = list.get(0);
        String mobile = factoryProduct.getProduct("mobile").getName();
        assertThat(product.getName()).isEqualTo(mobile);
    }

    @Test
    public void shouldThrowExceptionFactoryProduct() {
        try {
            String mobile = factoryProduct.getProduct("exit").getName();
        } catch (Exception e) {
            assertThat(e.getMessage()).isEqualTo("Product not found!");
            return;
        }
        new Exception("Expected exception");
    }
}
