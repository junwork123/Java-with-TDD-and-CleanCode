package org.cleancode.calculator.calcuables;

import org.cleancode.calculator.calcuables.interfaces.HandleAs;
import org.cleancode.calculator.calcuables.interfaces.HandleFor;
import org.cleancode.calculator.calcuables.interfaces.Operable;
import org.cleancode.calculator.pattern.CalculablePattern;
import org.cleancode.calculator.pattern.OperablePattern;

import java.util.List;

@HandleFor(target = CalculablePattern.POINT)
public enum PointOperator implements Operable {
    @HandleAs(symbol = OperablePattern.ADD)
    ADD {
        @Override
        public String apply(List<String> items) {
            Point a = Point.of(items.get(0));
            Point b = Point.of(items.get(1));
            return new Point(new Number(a.getX().getValue() + b.getX().getValue())
                    , new Number(a.getY().getValue() + b.getY().getValue())).toString();
        }
    },
    @HandleAs(symbol = OperablePattern.SUBTRACT)
    SUBTRACT {
        @Override
        public String apply(List<String> items) {
            Point a = Point.of(items.get(0));
            Point b = Point.of(items.get(1));
            return new Point(new Number(a.getX().getValue() - b.getX().getValue())
                    , new Number(a.getY().getValue() - b.getY().getValue())).toString();
        }
    },
    @HandleAs(symbol = OperablePattern.DISTANCE)
    DISTANCE {
        @Override
        public String apply(List<String> items) {
            Point a = Point.of(items.get(0));
            Point b = Point.of(items.get(1));
            double result = Math.sqrt(Math.pow(a.getX().getValue() - b.getX().getValue(), 2)
                                        + Math.pow(a.getY().getValue() - b.getY().getValue(), 2));
            return new Number((int) result).toString();
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
