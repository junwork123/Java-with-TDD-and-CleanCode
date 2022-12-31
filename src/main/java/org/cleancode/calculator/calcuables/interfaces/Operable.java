package org.cleancode.calculator.calcuables.interfaces;

public interface Operable<T> {
    T apply(T a, T b);
    String getSymbol();
}
