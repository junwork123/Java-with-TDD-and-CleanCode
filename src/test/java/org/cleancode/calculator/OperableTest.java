package org.cleancode.calculator;

import org.cleancode.calculator.calcuables.Number;
import org.cleancode.calculator.calcuables.NumberOperator;
import org.cleancode.calculator.calcuables.Point;
import org.cleancode.calculator.calcuables.PointOperator;
import org.cleancode.calculator.calcuables.interfaces.Operable;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class OperableTest {
    private final double x = 3;
    private final double y = 7;
    List<String> itemsOfNumber = List.of("3", "7");
    List<String> itemsOfPoint = List.of("(3,7)", "(7,3)");
    @Test
    public void operate_Number()  {
        assertThat(NumberOperator.ADD.apply(itemsOfNumber)).isEqualTo(new Number(x+y).toString());
        assertThat(NumberOperator.SUBTRACT.apply(itemsOfNumber)).isEqualTo(new Number(x-y).toString());
        assertThat(NumberOperator.MULTIPLY.apply(itemsOfNumber)).isEqualTo(new Number(x*y).toString());
        assertThat(NumberOperator.DIVIDE.apply(itemsOfNumber)).isEqualTo(new Number(x/y).toString());
    }
    @Test
    public void operate_Point()  {
        assertThat(PointOperator.ADD.apply(itemsOfPoint)).isEqualTo(new Point(new Number(x+y), new Number(y+x)).toString());
        assertThat(PointOperator.SUBTRACT.apply(itemsOfPoint)).isEqualTo(new Point(new Number(x-y), new Number(y-x)).toString());
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
