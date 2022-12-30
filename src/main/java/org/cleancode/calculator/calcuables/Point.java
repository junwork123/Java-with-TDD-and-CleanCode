package org.cleancode.calculator.calcuables;

import java.util.Objects;

public class Point implements Calculable<Point> {
    private Number x;
    private Number y;
    public Point(Number x, Number y){
        this.x = x;
        this.y = y;
    }
    public Number getX() {
        return this.x;
    }

    public Number getY() {
        return this.y;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point)) return false;
        Point point = (Point) o;
        return Objects.equals(x, point.x) && Objects.equals(y, point.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public Point add(Point item) {
        this.x.add(item.getX());
        this.y.add(item.getY());
        return this;
    }

    @Override
    public Point subtract(Point item) {
        this.x.subtract(item.getX());
        this.y.subtract(item.getY());
        return this;
    }

    @Override
    public Point multiply(Point item) {
        this.x.multiply(item.getX());
        this.y.multiply(item.getY());
        return this;
    }

    @Override
    public Point divide(Point item) {
        this.x.divide(item.getX());
        this.y.divide(item.getY());
        return this;
    }
}
