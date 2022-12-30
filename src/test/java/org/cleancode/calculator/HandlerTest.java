package org.cleancode.calculator;

import org.cleancode.calculator.handlers.NumberHandler;
import org.cleancode.calculator.handlers.OperatorHandler;
import org.cleancode.calculator.handlers.PointHandler;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class HandlerTest {
    @ParameterizedTest
    @CsvSource(value = {"+:true", "+-:false", "+-/*:false", "~:false", "qwe:false"}, delimiter = ':')
    public void supports_Operator(String input, boolean expected){
        assertThat(OperatorHandler.canHandle(input)).isEqualTo(expected);
    }
    @ParameterizedTest
    @CsvSource(value = {"123:true", "+123:true", "--123:false", "-123+:false", "-:false", "-+:false", "1q2w3e4r:false"}, delimiter = ':')
    public void supports_Number(String input, boolean expected){
        assertThat(NumberHandler.canHandle(input)).isEqualTo(expected);
    }
    @ParameterizedTest
    @CsvSource(value = {"(1,2):true", "(+1,-2):true", "1,2:false", "-1,+2:false", "-123:false", "-+:false", "1q2w3e4r:false"}, delimiter = ':')
    public void supports_Point(String input, boolean expected){
        assertThat(PointHandler.canHandle(input)).isEqualTo(expected);
    }
}
