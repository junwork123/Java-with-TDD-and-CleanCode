package org.cleancode.rentcompany.fueltanks.config;

public class FuelTankConfig {
    private final TankSize size;
    private final TankType type;
    private FuelTankConfig(TankSize size, TankType type) {
        this.size = size;
        this.type = type;
    }

    public TankSize getSize() {
        return size;
    }

    public TankType getType() {
        return type;
    }

    public static class Builder {
        private TankSize size;
        private TankType type;
        public Builder size(TankSize size) {
            this.size = size;
            return this;
        }
        public Builder type(TankType type) {
            this.type = type;
            return this;
        }
        public FuelTankConfig build() {
            return new FuelTankConfig(size, type);
        }
    }
}
