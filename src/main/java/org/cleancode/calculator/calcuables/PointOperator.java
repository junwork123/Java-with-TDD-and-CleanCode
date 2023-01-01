package org.cleancode.calculator.calcuables;

import org.cleancode.calculator.calcuables.interfaces.Operable;
import org.cleancode.calculator.pattern.CalculablePattern;
import org.cleancode.calculator.pattern.PatternHandler;
import org.cleancode.calculator.pattern.interfaces.HandleFor;

import java.util.Arrays;

@HandleFor(target = CalculablePattern.POINT)
public enum PointOperator implements Operable<Point> {
    ADD("+") {
        @Override
        public Point apply(Point a, Point b) {
            return new Point(NumberOperator.ADD.apply(a.getX(), b.getX()), NumberOperator.ADD.apply(a.getY(), b.getY()));
        }
    },
    SUBTRACT("-") {
        @Override
        public Point apply(Point a, Point b) {
            return new Point(NumberOperator.SUBTRACT.apply(a.getX(), b.getX()), NumberOperator.SUBTRACT.apply(a.getY(), b.getY()));
        }
    },
    MULTIPLY("*") {
        @Override
        public Point apply(Point a, Point b) {
            return new Point(NumberOperator.MULTIPLY.apply(a.getX(), b.getX()), NumberOperator.MULTIPLY.apply(a.getY(), b.getY()));
        }
    },
    DIVIDE("/") {
        @Override
        public Point apply(Point a, Point b) {
            return new Point(NumberOperator.DIVIDE.apply(a.getX(), b.getX()), NumberOperator.DIVIDE.apply(a.getY(), b.getY()));
        }
    };
    private final String symbol;

    PointOperator(String symbol) {
        this.symbol = symbol;
    }
    @Override
    public String getSymbol() {
        return this.symbol;
    }

    private static PointOperator of(String item) {
        if(!supports(item)){
            throw new IllegalArgumentException("Invalid input");
        }
        return Arrays.stream(PointOperator.values())
                .filter(numberOperator -> numberOperator.getSymbol().equals(item))
                .findFirst()
                .orElseThrow();
    }
    public static boolean supports(String item){
        return PatternHandler.supports(PointOperator.class, item);
    }
}
