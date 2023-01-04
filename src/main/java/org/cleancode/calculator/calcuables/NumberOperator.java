package org.cleancode.calculator.calcuables;

import org.cleancode.calculator.calcuables.interfaces.Operable;
import org.cleancode.calculator.pattern.CalculablePattern;
import org.cleancode.calculator.calcuables.interfaces.HandleAs;
import org.cleancode.calculator.calcuables.interfaces.HandleFor;
import org.cleancode.calculator.pattern.OperablePattern;

import java.util.List;

@HandleFor(target = CalculablePattern.NUMBER)
public enum NumberOperator implements Operable {
    @HandleAs(symbol = OperablePattern.ADD)
    ADD {
        @Override
        public String apply(List<String> items) {
            Number a = Number.of(items.get(0));
            Number b = Number.of(items.get(1));
            return new Number(a.getValue() + b.getValue()).toString();
        }
    },
    @HandleAs(symbol = OperablePattern.SUBTRACT)
    SUBTRACT {
        @Override
        public String apply(List<String> items) {
            Number a = Number.of(items.get(0));
            Number b = Number.of(items.get(1));
            return new Number(a.getValue() - b.getValue()).toString();
        }
    },
    @HandleAs(symbol = OperablePattern.MULTIPLY)
    MULTIPLY{
        @Override
        public String apply(List<String> items) {
            Number a = Number.of(items.get(0));
            Number b = Number.of(items.get(1));
            return new Number(a.getValue() * b.getValue()).toString();
        }
    },
    @HandleAs(symbol = OperablePattern.DIVIDE)
    DIVIDE {
        @Override
        public String apply(List<String> items) {
            Number a = Number.of(items.get(0));
            Number b = Number.of(items.get(1));
            return new Number(a.getValue() / b.getValue()).toString();
        }
    };
    @Override
    public CalculablePattern getTarget() {
        return this.getDeclaringClass().getAnnotation(HandleFor.class).target();
    }
    @Override
    public OperablePattern getSymbol() {
        try {
            return this.getDeclaringClass().getField(name()).getAnnotation(HandleAs.class).symbol();
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public int getHowMany() {
        try {
            return this.getDeclaringClass().getField(name()).getAnnotation(HandleAs.class).howMany();
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }
}
