package org.cleancode.calculator;

import org.cleancode.calculator.calcuables.Number;
import org.cleancode.calculator.calcuables.NumberOperator;
import org.cleancode.calculator.calcuables.Point;
import org.cleancode.calculator.calcuables.PointOperator;
import org.cleancode.calculator.calcuables.interfaces.Operable;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class OperableTest {
    private final int x = 3;
    private final int y = 7;
    @Test
    public void operate_Number()  {
        assertThat(NumberOperator.ADD.apply(new Number(x), new Number(y))).isEqualTo(new Number(x+y));
        assertThat(NumberOperator.SUBTRACT.apply(new Number(x), new Number(y))).isEqualTo(new Number(x-y));
        assertThat(NumberOperator.MULTIPLY.apply(new Number(x), new Number(y))).isEqualTo(new Number(x*y));
        assertThat(NumberOperator.DIVIDE.apply(new Number(x), new Number(y))).isEqualTo(new Number(x/y));
    }
    @Test
    public void operate_Point()  {
        Point p1 = new Point(new Number(x), new Number(y));
        Point p2 = new Point(new Number(y), new Number(x));

        Point result = PointOperator.ADD.apply(p1, p2);
        assertThat(result.getX()).isEqualTo(new Number(x+y));
        assertThat(result.getY()).isEqualTo(new Number(y+x));

        result = PointOperator.SUBTRACT.apply(p1, p2);
        assertThat(result.getX()).isEqualTo(new Number(x-y));
        assertThat(result.getY()).isEqualTo(new Number(y-x));

        result = PointOperator.MULTIPLY.apply(p1, p2);
        assertThat(result.getX()).isEqualTo(new Number(x*y));
        assertThat(result.getY()).isEqualTo(new Number(y*x));

        result = PointOperator.DIVIDE.apply(p1, p2);
        assertThat(result.getX()).isEqualTo(new Number(x/y));
        assertThat(result.getY()).isEqualTo(new Number(y/x));
    }
    @ParameterizedTest
    @CsvSource(value = {"1+2:true", "+1 + 2:true", "+1++2:true"}, delimiter = ':')
    public void match_ADD_Number(String input, boolean expected)  {
        assertThat(Operable.isMatch(NumberOperator.ADD, input)).isEqualTo(expected); // << True
        assertThat(Operable.isMatch(NumberOperator.SUBTRACT, input)).isNotEqualTo(expected);
        assertThat(Operable.isMatch(NumberOperator.MULTIPLY, input)).isNotEqualTo(expected);
        assertThat(Operable.isMatch(NumberOperator.DIVIDE, input)).isNotEqualTo(expected);
    }
    @ParameterizedTest
    @CsvSource(value = {"1-2:true", "+1 - 2:true", "+1-+2:true"}, delimiter = ':')
    public void match_SUBTRACT_Number(String input, boolean expected)  {
        assertThat(Operable.isMatch(NumberOperator.ADD, input)).isNotEqualTo(expected);
        assertThat(Operable.isMatch(NumberOperator.SUBTRACT, input)).isEqualTo(expected); // << True
        assertThat(Operable.isMatch(NumberOperator.MULTIPLY, input)).isNotEqualTo(expected);
        assertThat(Operable.isMatch(NumberOperator.DIVIDE, input)).isNotEqualTo(expected);
    }
    @ParameterizedTest
    @CsvSource(value = {"1*2:true", "+1 * 2:true", "+1*+2:true"}, delimiter = ':')
    public void match_MULTIPLY_Number(String input, boolean expected)  {
        assertThat(Operable.isMatch(NumberOperator.ADD, input)).isNotEqualTo(expected);
        assertThat(Operable.isMatch(NumberOperator.SUBTRACT, input)).isNotEqualTo(expected);
        assertThat(Operable.isMatch(NumberOperator.MULTIPLY, input)).isEqualTo(expected); // << True
        assertThat(Operable.isMatch(NumberOperator.DIVIDE, input)).isNotEqualTo(expected);
    }
    @ParameterizedTest
    @CsvSource(value = {"1/2:true", "+1 / 2:true", "+1/+2:true"}, delimiter = ':')
    public void match_DIVIDE_Number(String input, boolean expected)  {
        assertThat(Operable.isMatch(NumberOperator.ADD, input)).isNotEqualTo(expected);
        assertThat(Operable.isMatch(NumberOperator.SUBTRACT, input)).isNotEqualTo(expected);
        assertThat(Operable.isMatch(NumberOperator.MULTIPLY, input)).isNotEqualTo(expected);
        assertThat(Operable.isMatch(NumberOperator.DIVIDE, input)).isEqualTo(expected); // << True
    }
}
