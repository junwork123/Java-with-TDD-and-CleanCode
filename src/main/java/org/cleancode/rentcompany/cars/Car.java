package org.cleancode.rentcompany.cars;

import org.cleancode.rentcompany.cars.config.CarConfig;
import org.cleancode.rentcompany.engines.Engine;
import org.cleancode.rentcompany.fueltanks.FuelTank;

import java.util.Objects;

public abstract class Car implements Movable {
    protected final Engine engine;
    protected final FuelTank fuelTank;
    protected String name;

    public Car(CarConfig config) {
        this.name = config.getName();
        this.fuelTank = config.getFuelTank();
        this.engine = config.getEngine();
    }

    public Engine getEngine() {
        return engine;
    }

    public FuelTank getFuelTank() {
        return fuelTank;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return Objects.equals(engine, car.engine) && Objects.equals(fuelTank, car.fuelTank) && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(engine, fuelTank, name);
    }
}
