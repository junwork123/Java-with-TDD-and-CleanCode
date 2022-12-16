package org.cleancode.coffeeshop;

import org.cleancode.coffeeshop.shop.Menu;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class MenuTest {
    @Test
    public void findMenu(){
        Menu menu = Menu.createDefaultMenuList();
        assertThat(menu.containsMenu("아메리카노")).isTrue();
        assertThat(menu.containsSize(1)).isTrue();
    }
}

