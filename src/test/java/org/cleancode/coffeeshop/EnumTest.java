package org.cleancode.coffeeshop;

import org.cleancode.coffeeshop.product.Beverage;
import org.cleancode.coffeeshop.product.Size;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class EnumTest {
    @Test
    public void findBeverage(){
        Beverage beverage = Beverage.of("아메리카노");
        assertThat(beverage).isEqualTo(Beverage.AMERICANO);
    }

    @Test
    public void findSize(){
        Size size = Size.of(1);
        assertThat(size).isEqualTo(Size.TALL);
    }
}
