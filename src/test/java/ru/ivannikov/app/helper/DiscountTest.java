package ru.ivannikov.app.helper;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class DiscountTest {

    private DiscountStrategy discount10 = new Discount10();
    private DiscountStrategy discount50 = new Discount50();

    @Test
    public void shouldReturnAmountWith10PercentDiscount() {
        final BigDecimal bigDecimal = new BigDecimal("10");
        BigDecimal bigDecimalVal = discount10.discountCalculate(bigDecimal.intValue());
        assertThat(bigDecimalVal).isEqualTo("1.0");
    }

    @Test
    public void shouldReturnAmountWith50PercentDiscount() {
        final BigDecimal bigDecimal = new BigDecimal("10");
        BigDecimal bigDecimalVal = discount50.discountCalculate(bigDecimal.intValue());
        assertThat(bigDecimalVal).isEqualTo("5.0");
    }
}
