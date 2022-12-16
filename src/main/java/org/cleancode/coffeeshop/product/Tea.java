package org.cleancode.coffeeshop.product;

public class Tea extends CaffeineBeverage {
    public Tea(Beverage beverage, Size size) {
        super(beverage, size);
    }

    @Override
    public CaffeineBeverage prepareRecipe() {
        boilWater();
        steepTeaBag();
        pourInCup();
        addLemon();
        complete();
        return this;
    }

    private void complete() {
        System.out.println("Complete");
    }

    private void addLemon() {
        System.out.println("Adding Lemon");
    }

    private void steepTeaBag() {
        System.out.println("Steeping the tea");
    }

    private void boilWater() {
        System.out.println("Boiling water");
    }

    @Override
    protected void pourInCup() {
        System.out.println("Pouring into cup");
    }
}

