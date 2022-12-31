package org.cleancode.calculator;

import org.cleancode.calculator.calcuables.Number;
import org.cleancode.calculator.calcuables.NumberOperator;
import org.cleancode.calculator.calcuables.Point;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class PatternHandlerTest {
    @ParameterizedTest
    @CsvSource(value = {"+:true", "+-:false", "+-/*:false", "~:false", "qwe:false"}, delimiter = ':')
    public void supports_Operator(String input, boolean expected){
        assertThat(NumberOperator.supports(input)).isEqualTo(expected);
    }
    @ParameterizedTest
    @CsvSource(value = {"123:true", "+123:true", "--123:false", "-123+:false", "-:false", "-+:false", "1q2w3e4r:false"}, delimiter = ':')
    public void supports_Number(String input, boolean expected){
        assertThat(Number.supports(input)).isEqualTo(expected);
    }
    @ParameterizedTest
    @CsvSource(value = {"(1,2):true", "(+1,-2):true", "1,2:false", "-1,+2:false", "-123:false", "-+:false", "1q2w3e4r:false"}, delimiter = ':')
    public void supports_Point(String input, boolean expected){
        assertThat(Point.supports(input)).isEqualTo(expected);
    }
}
