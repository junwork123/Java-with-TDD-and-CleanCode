package org.cleancode.rentcompany.engines.config;

public class EngineConfig {
    private final EngineType engineType;
    private final HorsePower horsePower;
    private final InjectionType injectionType;

    private EngineConfig(EngineType engineType, HorsePower horsePower, InjectionType injectionType) {
        this.engineType = engineType;
        this.horsePower = horsePower;
        this.injectionType = injectionType;
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

    public static class Builder {
        private EngineType type;
        private HorsePower horsePower;
        private InjectionType injectionType;

        public Builder type(EngineType type) {
            this.type = type;
            return this;
        }
        public Builder horsePower(HorsePower horsePower) {
            this.horsePower = horsePower;
            return this;
        }
        public Builder injectionType(InjectionType injectionType) {
            this.injectionType = injectionType;
            return this;
        }
        public EngineConfig build() {
            return new EngineConfig(type, horsePower, injectionType);
        }
    }
}
