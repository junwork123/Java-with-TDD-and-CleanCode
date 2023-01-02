package org.cleancode.calculator.calcuables;

import org.cleancode.calculator.calcuables.interfaces.HandleAs;
import org.cleancode.calculator.calcuables.interfaces.HandleFor;
import org.cleancode.calculator.calcuables.interfaces.Operable;
import org.cleancode.calculator.pattern.CalculablePattern;
import org.cleancode.calculator.pattern.OperablePattern;

@HandleFor(target = CalculablePattern.POINT)
public enum PointOperator implements Operable<Point> {
    @HandleAs(symbol = OperablePattern.ADD)
    ADD {
        @Override
        public Point apply(Point a, Point b) {
            return new Point(NumberOperator.ADD.apply(a.getX(), b.getX()), NumberOperator.ADD.apply(a.getY(), b.getY()));
        }
    },
    @HandleAs(symbol = OperablePattern.SUBTRACT)
    SUBTRACT {
        @Override
        public Point apply(Point a, Point b) {
            return new Point(NumberOperator.SUBTRACT.apply(a.getX(), b.getX()), NumberOperator.SUBTRACT.apply(a.getY(), b.getY()));
        }
    },
    @HandleAs(symbol = OperablePattern.MULTIPLY)
    MULTIPLY {
        @Override
        public Point apply(Point a, Point b) {
            return new Point(NumberOperator.MULTIPLY.apply(a.getX(), b.getX()), NumberOperator.MULTIPLY.apply(a.getY(), b.getY()));
        }
    },
    @HandleAs(symbol = OperablePattern.DIVIDE)
    DIVIDE {
        @Override
        public Point apply(Point a, Point b) {
            return new Point(NumberOperator.DIVIDE.apply(a.getX(), b.getX()), NumberOperator.DIVIDE.apply(a.getY(), b.getY()));
        }
    },
    @HandleAs(symbol = OperablePattern.DISTANCE)
    DISTANCE {
        @Override
        public Point apply(Point a, Point b) {
            return new Point(NumberOperator.SUBTRACT.apply(a.getX(), b.getX()), NumberOperator.SUBTRACT.apply(a.getY(), b.getY()));
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
