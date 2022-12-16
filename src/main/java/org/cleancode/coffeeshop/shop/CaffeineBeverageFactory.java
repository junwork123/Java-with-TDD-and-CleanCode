package org.cleancode.coffeeshop.shop;

import org.cleancode.coffeeshop.product.CaffeineBeverage;
import org.cleancode.coffeeshop.product.Coffee;
import org.cleancode.coffeeshop.product.Tea;

public class CaffeineBeverageFactory {
    public static CaffeineBeverage create(Order order) {
        CaffeineBeverage beverage;
        switch (order.getBeverage()) {
            case AMERICANO:
                beverage = new Coffee(order.getBeverage(), order.getSize());
                break;
            case BLACK_TEA:
                beverage = new Tea(order.getBeverage(), order.getSize());
                break;
            default:
                throw new IllegalArgumentException("음료를 찾을 수 없습니다.");
        }
        beverage.prepareRecipe();
        return beverage;
    }
}
