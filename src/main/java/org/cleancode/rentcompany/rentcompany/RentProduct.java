package org.cleancode.rentcompany.rentcompany;

import org.cleancode.rentcompany.cars.Car;

public class RentProduct {
    public static int COUNT = 0;
    private boolean isAvailable;
    private final int id;
    private final Car car;
    private RentProduct(Car car, boolean isAvailable) {
        this.id = COUNT++;
        this.car = car;
        this.isAvailable = isAvailable;
    }
    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }
    public boolean isAvailable() {
        return isAvailable;
    }
    public int getId() {
        return id;
    }
    public String getCarName() {
        return car.getName();
    }
    public boolean isSameCar(Class<? extends Car> car) {
        return car.equals(this.car.getClass());
    }

    public double getFuelEfficiency(double distance) {
        return distance / car.getDistancePerLiter();
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
