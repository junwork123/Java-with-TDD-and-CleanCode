package org.cleancode.coffeeshop.shop;

import org.cleancode.coffeeshop.product.CaffeineBeverage;

public class CoffeeShop {
    public Menu menu;
    public CoffeeShop() {
        this.menu = Menu.createDefaultMenuList();
    }

    public CaffeineBeverage order(String menuName) {
        return this.order(menuName, 1);
    }

    public CaffeineBeverage order(String menuName, int size){
        validate(menuName, size);
        Order order = new Order.OrderBuilder()
                .menuName(menuName)
                .size(size)
                .build();
        return CaffeineBeverageFactory
                .create(order)
                .prepareRecipe();
    }

    private void validate(String menuName, int size) {
        if (!menu.containsMenu(menuName)) {
            throw new IllegalArgumentException("메뉴를 찾을 수 없습니다.");
        }
        if (!menu.containsSize(size)) {
            throw new IllegalArgumentException("사이즈를 찾을 수 없습니다.");
        }
    }
}
