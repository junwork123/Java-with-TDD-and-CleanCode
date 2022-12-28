package org.cleancode.calculator;

import org.cleancode.calculator.calcuable.Number;
import org.cleancode.calculator.calcuable.Point;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CalculableTest {
    private final int x = 3;
    private final int y = 7;
    @Test
    public void create_Number(){
        Number number = new Number(1);
        assertThat(number).isEqualTo(new Number(1));
        assertThat(number.getValue()).isEqualTo(1);
    }
    @Test
    public void add_Number()  {
        assertThat(new Number(x+y)).isEqualTo(new Number(x).add(new Number(y)));
    }
    @Test
    public void subtract_Number() {
        assertThat(new Number(x-y)).isEqualTo(new Number(x).subtract(new Number(y)));
    }
    @Test
    public void multiply_Number()  {
        assertThat(new Number(x*y)).isEqualTo(new Number(x).multiply(new Number(y)));
    }
    @Test
    public void divide_Number()  {
        assertThat(new Number(x/y)).isEqualTo(new Number(x).divide(new Number(y)));
    }
    @Test
    public void create_Point()  {
        Point point = new Point(new Number(x), new Number(y));
        assertThat(point).isEqualTo(new Point(new Number(x), new Number(y)));
        assertThat(point.getX()).isEqualTo(new Number(x));
        assertThat(point.getY()).isEqualTo(new Number(y));
    }
    @Test
    public void add_Point()  {
        Point p1 = new Point(new Number(x), new Number(y));
        Point p2 = new Point(new Number(y), new Number(x));
        assertThat(p1.add(p2)).isEqualTo(new Point(new Number(x+y), new Number(y+x)));
    }
    @Test
    public void subtract_Point()  {
        Point p1 = new Point(new Number(x), new Number(y));
        Point p2 = new Point(new Number(y), new Number(x));
        assertThat(p1.subtract(p2)).isEqualTo(new Point(new Number(x-y), new Number(y-x)));
    }
    @Test
    public void multiply_Point()  {
        Point p1 = new Point(new Number(x), new Number(y));
        Point p2 = new Point(new Number(y), new Number(x));
        assertThat(p1.multiply(p2)).isEqualTo(new Point(new Number(x*y), new Number(y*x)));
    }
    @Test
    public void divide_Point()  {
        Point p1 = new Point(new Number(x), new Number(y));
        Point p2 = new Point(new Number(y), new Number(x));
        assertThat(p1.divide(p2)).isEqualTo(new Point(new Number(x/y), new Number(y/x)));
    }
}
