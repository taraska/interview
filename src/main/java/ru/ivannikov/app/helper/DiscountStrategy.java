package ru.ivannikov.app.helper;

import java.math.BigDecimal;

public interface DiscountStrategy {
    BigDecimal discountCalculate(int sum);
}
