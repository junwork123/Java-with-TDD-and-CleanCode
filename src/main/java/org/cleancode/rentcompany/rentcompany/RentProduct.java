package org.cleancode.rentcompany.rentcompany;

import org.cleancode.rentcompany.cars.Car;

public class RentProduct {
    public static int COUNT = 0;
    private boolean isAvailable;
    private final int id;
    private Car car;

    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }
    public boolean isAvailable() {
        return isAvailable;
    }
    public int getId() {
        return id;
    }
    public Car getCar() {
        return car;
    }

    private RentProduct(Car car, boolean isAvailable) {
        this.id = COUNT++;
        this.isAvailable = isAvailable;
    }

    public static class Builder{
        private boolean isAvailable;
        private Car car;
        public Builder isAvailable(boolean isAvailable){
            this.isAvailable = isAvailable;
            return this;
        }
        public Builder car(Car car){
            this.car = car;
            return this;
        }
        public RentProduct build(){
            return new RentProduct(this.car, this.isAvailable);
        }
    }
}
