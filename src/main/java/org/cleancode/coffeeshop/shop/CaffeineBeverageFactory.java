package org.cleancode.coffeeshop.shop;

import org.cleancode.coffeeshop.product.CaffeineBeverage;
import org.cleancode.coffeeshop.product.Coffee;
import org.cleancode.coffeeshop.product.Tea;

public class CaffeineBeverageFactory {
    public static CaffeineBeverage create(Order order) {
        switch (order.getBeverage()) {
            case AMERICANO:
                return new Coffee(order.getBeverage(), order.getSize());
            case BLACK_TEA:
                return new Tea(order.getBeverage(), order.getSize());
            default:
                throw new IllegalArgumentException("음료를 찾을 수 없습니다.");
        }
    }
}
