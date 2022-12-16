package org.cleancode.coffeeshop.product;

import java.util.Objects;

public abstract class CaffeineBeverage {
    private final Beverage beverage;
    private final Size size;
    public CaffeineBeverage(Beverage beverage, Size size) {
        this.beverage = beverage;
        this.size = size;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CaffeineBeverage)) return false;
        CaffeineBeverage beverage1 = (CaffeineBeverage) o;
        return beverage == beverage1.beverage && size == beverage1.size;
    }
    @Override
    public int hashCode() {
        return Objects.hash(beverage, size);
    }
    public Beverage getBeverage() {
        return beverage;
    }
    public Size getSize() {
        return size;
    }
    public abstract void prepareRecipe();
    protected abstract void pourInCup();
    protected abstract void addCondiments();
    protected abstract void brew();
    protected abstract void complete();
}
