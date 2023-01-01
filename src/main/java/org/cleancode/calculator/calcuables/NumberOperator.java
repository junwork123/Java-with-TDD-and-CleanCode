package org.cleancode.calculator.calcuables;

import org.cleancode.calculator.calcuables.interfaces.Operable;
import org.cleancode.calculator.pattern.CalculablePattern;
import org.cleancode.calculator.calcuables.interfaces.HandleAs;
import org.cleancode.calculator.calcuables.interfaces.HandleFor;
import org.cleancode.calculator.pattern.OperablePattern;

@HandleFor(target = CalculablePattern.NUMBER)
public enum NumberOperator implements Operable<Number> {
    @HandleAs(symbol = OperablePattern.ADD)
    ADD {
        @Override
        public Number apply(Number a, Number b) {
            return new Number(a.getValue() + b.getValue());
        }
    },
    @HandleAs(symbol = OperablePattern.SUBTRACT)
    SUBTRACT {
        @Override
        public Number apply(Number a, Number b) {
            return new Number(a.getValue() - b.getValue());
        }
    },
    @HandleAs(symbol = OperablePattern.MULTIPLY)
    MULTIPLY{
        @Override
        public Number apply(Number a, Number b) {
            return new Number(a.getValue() * b.getValue());
        }
    },
    @HandleAs(symbol = OperablePattern.DIVIDE)
    DIVIDE {
        @Override
        public Number apply(Number a, Number b) {
            return new Number(a.getValue() / b.getValue());
        }
    };

    @Override
    public OperablePattern getSymbol() {
        try {
            return this.getDeclaringClass().getField(name()).getAnnotation(HandleAs.class).symbol();
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }
}
