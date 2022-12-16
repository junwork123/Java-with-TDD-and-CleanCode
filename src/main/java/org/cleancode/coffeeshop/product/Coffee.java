package org.cleancode.coffeeshop.product;

public class Coffee extends CaffeineBeverage {
    public Coffee(Beverage beverage, Size size) {
        super(beverage, size);
    }

    public void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        addCondiments();
        complete();
    }
    @Override
    protected void complete() {
        System.out.println("Complete");
    }
    @Override
    protected void brew() {
        System.out.println("Dripping Coffee through filter");
    }
    @Override
    protected void addCondiments() {
        System.out.println("Adding Sugar and Milk");
    }
    private void boilWater() {
        System.out.println("Boiling water");
    }

    @Override
    protected void pourInCup() {
        System.out.println("Pouring into cup");
    }
}
