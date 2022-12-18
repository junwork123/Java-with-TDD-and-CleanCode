package org.cleancode.rentcompany.fueltanks.config;

public enum TankSize {
    SMALL(50),
    MIDDLE(100),
    BIG(200);

    private final double capacity;

    TankSize(double capacity) {
        this.capacity = capacity;
    }

    public double getCapacity() {
        return capacity;
    }
}
