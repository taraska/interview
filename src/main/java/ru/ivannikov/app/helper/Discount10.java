package ru.ivannikov.app.helper;

import java.math.BigDecimal;

public class Discount10 implements DiscountStrategy {

    private BigDecimal bigDecimal = new BigDecimal("0.1");

    @Override
    public BigDecimal discountCalculate(int sum) {
        return bigDecimal.multiply(new BigDecimal(sum));
    }
}
