package org.cleancode.rentcompany.engines;

import org.cleancode.rentcompany.engines.config.EngineConfig;
import org.cleancode.rentcompany.engines.config.EngineType;
import org.cleancode.rentcompany.engines.config.HorsePower;
import org.cleancode.rentcompany.engines.config.InjectionType;

public class Engine {
    private final EngineType engineType;

    private final HorsePower horsePower;
    private final InjectionType injectionType;
    protected Engine(EngineConfig config) {
        this.engineType = config.getEngineType();
        this.horsePower = config.getHorsePower();
        this.injectionType = config.getInjectionType();
    }
    public EngineType getEngineType() {
        return engineType;
    }

    public HorsePower getHorsePower() {
        return horsePower;
    }

    public InjectionType getInjectionType() {
        return injectionType;
    }
}
