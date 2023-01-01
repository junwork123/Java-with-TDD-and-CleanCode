package org.cleancode.calculator.calcuables.interfaces;

import org.cleancode.calculator.pattern.OperablePattern;

public interface Operable<T> {
    T apply(T a, T b);
    OperablePattern getSymbol();
}
