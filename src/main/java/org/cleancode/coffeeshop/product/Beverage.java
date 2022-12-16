package org.cleancode.coffeeshop.product;

import java.util.Arrays;

public enum Beverage {
    AMERICANO("아메리카노"),
    BLACK_TEA("홍차");

    private final String menuName;

    Beverage(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuName() {
        return menuName;
    }

    public static Beverage of(String menuName) {
        return Arrays.stream(Beverage.values())
                .filter(item -> item.getMenuName().equals(menuName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("메뉴 이름를 찾을 수 없습니다."));
    }
}
