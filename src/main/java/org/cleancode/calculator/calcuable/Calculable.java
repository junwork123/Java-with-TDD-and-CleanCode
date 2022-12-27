package org.cleancode.calculator.calcuable;

public interface Calculable<T> {
    T add(T item);
    T subtract(T item);
    T multiply(T item);
    T divide(T item);
}
