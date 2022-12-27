package org.cleancode.calculator.calcuable;

import org.cleancode.calculator.handler.NumberHandler;

import java.util.Objects;

public class Number implements Calculable<Number> {
    private int number;

    public Number(int number){
        this.number = number;
    }

    public Number(String number) {
        if(!NumberHandler.supports(number)){
            throw new IllegalArgumentException("잘못된 숫자입니다.");
        }
        this.number = Integer.parseInt(number);
    }
    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Number)) return false;
        Number number1 = (Number) o;
        return number == number1.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public Number add(Number item) {
        this.number = this.number + item.getNumber();
        return this;
    }

    @Override
    public Number subtract(Number item) {
        this.number = this.number - item.getNumber();
        return this;
    }

    @Override
    public Number multiply(Number item) {
        this.number = this.number * item.getNumber();
        return this;
    }

    @Override
    public Number divide(Number item) {
        this.number = this.number / item.getNumber();
        return this;
    }
}
