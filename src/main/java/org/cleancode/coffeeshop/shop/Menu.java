package org.cleancode.coffeeshop.shop;

import org.cleancode.coffeeshop.product.Beverage;
import org.cleancode.coffeeshop.product.Size;

import java.util.HashMap;
import java.util.Map;

public class Menu {
    public final Map<Beverage, Integer> beverageMap;
    public final Map<Size, Integer> sizeMap;

    public Menu(Map<Beverage, Integer> beverageMap, Map<Size, Integer> sizeMap) {
        this.beverageMap = beverageMap;
        this.sizeMap = sizeMap;
    }

    public boolean containsMenu(String menuName){
        return beverageMap.keySet().stream()
                .map(Beverage::getMenuName)
                .anyMatch(menuName::equals);
    }

    public boolean containsSize(Integer size){
        return sizeMap.keySet().stream()
                .map(Size::getSize)
                .anyMatch(size::equals);
    }

    public static Menu createDefaultMenuList(){
        Map<Size, Integer> sizeMap = new HashMap<>();
        sizeMap.put(Size.TALL, 0);
        sizeMap.put(Size.GRANDE, 700);
        sizeMap.put(Size.VENTI, 1500);

        Map<Beverage, Integer> beverageMap = new HashMap<>();
        beverageMap.put(Beverage.AMERICANO, 3000);
        beverageMap.put(Beverage.BLACK_TEA, 4000);

        return new Menu(beverageMap, sizeMap);
    }
}
