package org.cleancode.calculator;

import org.cleancode.calculator.calcuables.Number;
import org.cleancode.calculator.calcuables.Point;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculableTest {
    @Test
    public void create_Number(){
        Number number = new Number(1);
        assertThat(number).isEqualTo(new Number(1));
        assertThat(number.getValue()).isEqualTo(1);
    }
    @Test
    public void create_Point()  {
        Point point = new Point(new Number(1), new Number(2));
        assertThat(point).isEqualTo(new Point(new Number(1), new Number(2)));
        assertThat(point.getX()).isEqualTo(new Number(1));
        assertThat(point.getY()).isEqualTo(new Number(2));
    }
}
