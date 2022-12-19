package org.cleancode.rentcompany;

import org.cleancode.rentcompany.engines.*;
import org.cleancode.rentcompany.engines.config.EngineConfig;
import org.cleancode.rentcompany.engines.config.EngineType;
import org.cleancode.rentcompany.engines.config.HorsePower;
import org.cleancode.rentcompany.engines.config.InjectionType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class EngineTest {
    EngineConfig dieselConfig;
    EngineConfig electricConfig;
    EngineConfig gasConfig;
    @BeforeEach
    public void setUp() {
        dieselConfig = new EngineConfig.Builder()
                .type(EngineType.DIESEL)
                .horsePower(HorsePower.SMALL)
                .injectionType(InjectionType.GDI)
                .build();
        electricConfig = new EngineConfig.Builder()
                .type(EngineType.ELECTRIC)
                .horsePower(HorsePower.MEDIUM)
                .injectionType(InjectionType.MPI)
                .build();
        gasConfig = new EngineConfig.Builder()
                .type(EngineType.GAS)
                .horsePower(HorsePower.LARGE)
                .injectionType(InjectionType.CRDI)
                .build();
    }
    @Test
    public void create(){
        Engine engine = EngineFactory.create(dieselConfig);
        assertThat(engine.getEngineType()).isEqualTo(dieselConfig.getEngineType());
        assertThat(engine.getHorsePower()).isEqualTo(dieselConfig.getHorsePower());
        assertThat(engine.getInjectionType()).isEqualTo(dieselConfig.getInjectionType());
    }
    @Test
    public void createVariousEngine(){
        assertThat(EngineFactory.create(dieselConfig)).isInstanceOf(DieselEngine.class);
        assertThat(EngineFactory.create(electricConfig)).isInstanceOf(ElectricEngine.class);
        assertThat(EngineFactory.create(gasConfig)).isInstanceOf(GasEngine.class);
    }
}
