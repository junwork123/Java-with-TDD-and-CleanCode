package org.cleancode.calculator.calcuables;

import org.cleancode.calculator.calcuables.interfaces.Operable;
import org.cleancode.calculator.pattern.CalculablePattern;
import org.cleancode.calculator.pattern.PatternHandler;
import org.cleancode.calculator.pattern.interfaces.HandleFor;

import java.util.Arrays;
@HandleFor(target = CalculablePattern.NUMBER)
public enum NumberOperator implements Operable<Number> {
    ADD("+") {
        @Override
        public Number apply(Number a, Number b) {
            return new Number(a.getValue() + b.getValue());
        }
    },
    SUBTRACT("-") {
        @Override
        public Number apply(Number a, Number b) {
            return new Number(a.getValue() - b.getValue());
        }
    },
    MULTIPLY("*") {
        @Override
        public Number apply(Number a, Number b) {
            return new Number(a.getValue() * b.getValue());
        }
    },
    DIVIDE("/") {
        @Override
        public Number apply(Number a, Number b) {
            return new Number(a.getValue() / b.getValue());
        }
    };
    private final String symbol;

    NumberOperator(String symbol) {
        this.symbol = symbol;
    }
    @Override
    public String getSymbol() {
        return this.symbol;
    }

    private static NumberOperator of(String item) {
        if(!supports(item)){
            throw new IllegalArgumentException("Invalid input");
        }
        return Arrays.stream(NumberOperator.values())
                .filter(numberOperator -> numberOperator.getSymbol().equals(item))
                .findFirst()
                .orElseThrow();
    }
    public static boolean supports(String item){
        return PatternHandler.supports(NumberOperator.class, item);
    }
}
