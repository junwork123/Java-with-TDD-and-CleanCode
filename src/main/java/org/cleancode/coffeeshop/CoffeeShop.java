package org.cleancode.coffeeshop;

import org.cleancode.coffeeshop.product.CaffeineBeverage;
import org.cleancode.coffeeshop.shop.CaffeineBeverageFactory;
import org.cleancode.coffeeshop.shop.Menu;
import org.cleancode.coffeeshop.shop.Order;

public class CoffeeShop {
    private final Menu menu;
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
        pay(order);
        return CaffeineBeverageFactory
                .create(order);
    }

    private void pay(Order order) {
        System.out.println(order.toString());
        System.out.println(menu.getPrice(order) + "원 결제 완료");
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
