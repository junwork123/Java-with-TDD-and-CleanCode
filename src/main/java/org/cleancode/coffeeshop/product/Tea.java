package org.cleancode.coffeeshop.product;

import java.util.Objects;

public class Tea implements CaffeineBeverage {
    private final Beverage beverage;
    private final Size size;
    public Tea(Beverage beverage, Size size) {
        this.beverage = beverage;
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tea)) return false;
        Tea tea = (Tea) o;
        return beverage == tea.beverage && size == tea.size;
    }
    @Override
    public int hashCode() {
        return Objects.hash(beverage, size);
    }
    @Override
    public CaffeineBeverage prepareRecipe() {
        boilWater();
        steepTeaBag();
        pourInCup();
        addLemon();
        return this;
    }

    private void addLemon() {
        System.out.println("Adding Lemon");
    }

    private void pourInCup() {
        System.out.println("Pouring into cup");
    }

    private void steepTeaBag() {
        System.out.println("Steeping the tea");
    }

    private void boilWater() {
        System.out.println("Boiling water");
    }
}

