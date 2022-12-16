package org.cleancode.coffeeshop.product;

public class Tea extends CaffeineBeverage {
    public Tea(Beverage beverage, Size size) {
        super(beverage, size);
    }

    @Override
    public void prepareRecipe() {
        brew();
        steepTeaBag();
        pourInCup();
        addCondiments();
        complete();
    }

    private void steepTeaBag() {
        System.out.println("Steeping the tea");
    }

    @Override
    protected void complete() {
        System.out.println("Complete");
    }

    @Override
    protected void addCondiments() {
        System.out.println("Adding Lemon");
    }

    @Override
    protected void brew() {
        System.out.println("Boiling water");
    }

    @Override
    protected void pourInCup() {
        System.out.println("Pouring into cup");
    }
}

