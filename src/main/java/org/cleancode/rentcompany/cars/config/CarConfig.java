package org.cleancode.rentcompany.cars.config;

import org.cleancode.rentcompany.engines.Engine;
import org.cleancode.rentcompany.fueltanks.FuelTank;

public class CarConfig {
    private final String name;
    private final Engine engine;
    private final FuelTank fuelTank;

    private CarConfig(String name, Engine engine, FuelTank fuelTank) {
        this.name = name;
        this.engine = engine;
        this.fuelTank = fuelTank;
    }

    public String getName() {
        return name;
    }

    public Engine getEngine() {
        return engine;
    }

    public FuelTank getFuelTank() {
        return fuelTank;
    }
    public static class Builder {
        private String name;
        private Engine engine;
        private FuelTank fuelTank;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder engine(Engine engine) {
            this.engine = engine;
            return this;
        }

        public Builder fuelTank(FuelTank fuelTank) {
            this.fuelTank = fuelTank;
            return this;
        }

        public CarConfig build() {
            return new CarConfig(name, engine, fuelTank);
        }
    }
}
