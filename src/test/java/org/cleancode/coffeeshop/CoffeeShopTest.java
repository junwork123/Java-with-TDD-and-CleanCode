package org.cleancode.coffeeshop;

import org.cleancode.coffeeshop.product.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CoffeeShopTest {
    CoffeeShop coffeeShop;

    @BeforeEach
    public void setUp() {
        this.coffeeShop = new CoffeeShop();
    }

    @Test
    public void order(){
        // 커피
        CaffeineBeverage beverage = coffeeShop.order("아메리카노", 1);
        assertThat(beverage).isInstanceOf(Coffee.class);

        Coffee coffee = (Coffee) beverage;
        assertThat(coffee).isEqualTo(new Coffee(Beverage.AMERICANO, Size.TALL));

        // 홍차
        CaffeineBeverage beverage2 = coffeeShop.order("홍차", 2);
        assertThat(beverage2).isInstanceOf(Tea.class);

        Tea tea = (Tea) beverage2;
        assertThat(tea).isEqualTo(new Tea(Beverage.BLACK_TEA, Size.GRANDE));
    }

    @Test void orderFail(){
        assertThatThrownBy(() -> coffeeShop.order("없는 음료", 1))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> coffeeShop.order("아메리카노", 4))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
