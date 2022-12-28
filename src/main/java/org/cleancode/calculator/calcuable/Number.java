package org.cleancode.calculator.calcuable;

import java.util.Objects;

public class Number implements Calculable<Number> {
    private int value;
    public Number(int value){
        this.value = value;
    }
    public int getValue() {
        return value;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Number)) return false;
        Number number1 = (Number) o;
        return value == number1.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public Number add(Number item) {
        this.value = this.value + item.getValue();
        return this;
    }

    @Override
    public Number subtract(Number item) {
        this.value = this.value - item.getValue();
        return this;
    }

    @Override
    public Number multiply(Number item) {
        this.value = this.value * item.getValue();
        return this;
    }

    @Override
    public Number divide(Number item) {
        this.value = this.value / item.getValue();
        return this;
    }
}
