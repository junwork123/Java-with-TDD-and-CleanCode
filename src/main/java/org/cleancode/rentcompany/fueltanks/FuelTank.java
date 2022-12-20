package org.cleancode.rentcompany.fueltanks;

import org.cleancode.rentcompany.fueltanks.config.FuelTankConfig;
import org.cleancode.rentcompany.fueltanks.config.TankSize;
import org.cleancode.rentcompany.fueltanks.config.TankType;

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

}
