package org.cleancode.coffeeshop;

import org.cleancode.coffeeshop.product.Beverage;
import org.cleancode.coffeeshop.product.CaffeineBeverage;
import org.cleancode.coffeeshop.product.Coffee;
import org.cleancode.coffeeshop.product.Size;
import org.cleancode.coffeeshop.shop.CaffeineBeverageFactory;
import org.cleancode.coffeeshop.shop.CoffeeShop;
import org.cleancode.coffeeshop.shop.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class CoffeeShopTest {
    CoffeeShop coffeeShop;
    Order order;

    @BeforeEach
    public void setUp() {
        this.coffeeShop = new CoffeeShop();
        this.order = new Order.OrderBuilder()
                .menuName("아메리카노")
                .size(1)
                .build();
    }

    @Test
    public void create(){
        CaffeineBeverage beverage = CaffeineBeverageFactory.create(order);

        assertThat(beverage).isInstanceOf(Coffee.class);

        Coffee coffee = (Coffee) beverage;
        assertThat(coffee).isEqualTo(new Coffee(Beverage.AMERICANO, Size.TALL));
    }

    @Test
    public void order(){
        CaffeineBeverage caffeineBeverage = coffeeShop.order("아메리카노", 1);

        assertThat(caffeineBeverage).isInstanceOf(Coffee.class);

        Coffee coffee = (Coffee) caffeineBeverage;
        assertThat(coffee).isEqualTo(new Coffee(Beverage.AMERICANO, Size.TALL));
    }

    @Test void orderFail(){
        assertThatThrownBy(() -> coffeeShop.order("없는 음료", 1))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> coffeeShop.order("아메리카노", 4))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
