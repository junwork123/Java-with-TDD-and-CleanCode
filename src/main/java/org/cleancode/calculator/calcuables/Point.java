package org.cleancode.calculator.calcuables;

import org.cleancode.calculator.calcuables.interfaces.Calculable;
import org.cleancode.calculator.pattern.CalculablePattern;
import org.cleancode.calculator.calcuables.interfaces.HandleFor;

import java.util.Objects;

@HandleFor(target = CalculablePattern.POINT)
public class Point implements Calculable {
    private final Number x;
    private final Number y;
    public static Point of(String item){
        String[] split = item.replaceAll("[()]", "").split(",");
        return new Point(Number.of(split[0]), Number.of(split[1]));
    }
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
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}
