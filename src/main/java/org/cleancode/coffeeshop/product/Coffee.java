package org.cleancode.coffeeshop.product;

public class Coffee extends CaffeineBeverage {
    public Coffee(Beverage beverage, Size size) {
        super(beverage, size);
    }

    public CaffeineBeverage prepareRecipe() {
        boilWater();
        brewCoffeeGrinds();
        pourInCup();
        addSugarAndMilk();
        complete();
        return this;
    }

    private void complete() {
        System.out.println("Complete");
    }

    private void addSugarAndMilk() {
        System.out.println("Adding Sugar and Milk");
    }

    private void brewCoffeeGrinds() {
        System.out.println("Dripping Coffee through filter");
    }

    private void boilWater() {
        System.out.println("Boiling water");
    }

    @Override
    protected void pourInCup() {
        System.out.println("Pouring into cup");
    }
}
