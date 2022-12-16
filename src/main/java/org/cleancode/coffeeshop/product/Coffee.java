package org.cleancode.coffeeshop.product;

import java.util.Objects;

public class Coffee implements CaffeineBeverage {

    private final Beverage beverage;
    private final Size size;
    public Coffee(Beverage beverage, Size size) {
        this.beverage = beverage;
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coffee)) return false;
        Coffee coffee = (Coffee) o;
        return beverage == coffee.beverage && size == coffee.size;
    }

    @Override
    public int hashCode() {
        return Objects.hash(beverage, size);
    }

    @Override
    public CaffeineBeverage prepareRecipe() {
        boilWater();
        brewCoffeeGrinds();
        pourInCup();
        addSugarAndMilk();
        return this;
    }

    private void addSugarAndMilk() {
        System.out.println("Adding Sugar and Milk");
    }

    private void pourInCup() {
        System.out.println("Pouring into cup");
    }

    private void brewCoffeeGrinds() {
        System.out.println("Dripping Coffee through filter");
    }

    private void boilWater() {
        System.out.println("Boiling water");
    }
}
