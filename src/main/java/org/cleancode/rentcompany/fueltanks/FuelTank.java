package org.cleancode.rentcompany.fueltanks;

import org.cleancode.rentcompany.fueltanks.config.FuelTankConfig;
import org.cleancode.rentcompany.fueltanks.config.TankSize;
import org.cleancode.rentcompany.fueltanks.config.TankType;

import java.util.Objects;

public abstract class FuelTank {
    private final TankType type;
    private final TankSize size;

    protected FuelTank(FuelTankConfig config) {
        this.size = config.getSize();
        this.type = config.getType();
    }
    public TankType getType() {
        return type;
    }
    public TankSize getSize() {
        return size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FuelTank)) return false;
        FuelTank fuelTank = (FuelTank) o;
        return type == fuelTank.type && size == fuelTank.size;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, size);
    }
}
