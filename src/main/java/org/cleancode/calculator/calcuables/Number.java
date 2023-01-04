package org.cleancode.calculator.calcuables;

import org.cleancode.calculator.calcuables.interfaces.Calculable;
import org.cleancode.calculator.pattern.CalculablePattern;
import org.cleancode.calculator.calcuables.interfaces.HandleFor;

import java.util.Objects;

@HandleFor(target = CalculablePattern.NUMBER)
public class Number implements Calculable {
    private final int value;
    public static Number of(String item){
        return new Number(Integer.parseInt(item));
    }
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
    public String toString() {
        return String.valueOf(value);
    }
}
