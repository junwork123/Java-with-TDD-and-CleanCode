package org.cleancode.coffeeshop.shop;

import org.cleancode.coffeeshop.product.Beverage;
import org.cleancode.coffeeshop.product.Size;

public class Order {
    private final Beverage beverage;
    private final Size size;
    private Order(Beverage beverage, Size size) {
        this.beverage = beverage;
        this.size = size;
    }

    public Beverage getBeverage() {
        return this.beverage;
    }

    public Size getSize() {
        return this.size;
    }

    public static class OrderBuilder {
        private String menuName;
        private int size;
        public OrderBuilder menuName(String menuName) {
            this.menuName = menuName;
            return this;
        }

        public OrderBuilder size(int size) {
            this.size = size;
            return this;
        }

        public Order build() {
            return new Order(Beverage.of(menuName), Size.of(size));
        }
    }
}
