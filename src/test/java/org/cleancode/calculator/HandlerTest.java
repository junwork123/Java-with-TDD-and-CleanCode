package org.cleancode.calculator;

import org.cleancode.calculator.handler.NumberHandler;
import org.cleancode.calculator.handler.OperatorHandler;
import org.cleancode.calculator.handler.PointHandler;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HandlerTest {
    @Test
    public void supports_Operator(){
        assertThat(OperatorHandler.isSupports("+")).isEqualTo(true);
        assertThat(OperatorHandler.isSupports("+-")).isEqualTo(false);
        assertThat(OperatorHandler.isSupports("+-/*")).isEqualTo(false);
        assertThat(OperatorHandler.isSupports("qwe")).isEqualTo(false);
        assertThat(OperatorHandler.isSupports("~")).isEqualTo(false);
    }
    @Test
    public void supports_Number(){
        assertThat(NumberHandler.isSupports("123")).isEqualTo(true);
        assertThat(NumberHandler.isSupports("+123")).isEqualTo(true);
        assertThat(NumberHandler.isSupports("1q2w3e4r")).isEqualTo(false);
        assertThat(NumberHandler.isSupports("--123")).isEqualTo(false);
        assertThat(NumberHandler.isSupports("-123+")).isEqualTo(false);
        assertThat(NumberHandler.isSupports("-")).isEqualTo(false);
        assertThat(NumberHandler.isSupports("-+")).isEqualTo(false);
    }
    @Test
    public void supports_Point(){
        assertThat(PointHandler.isSupports("(1,2)")).isEqualTo(true);
        assertThat(PointHandler.isSupports("(+1,-2)")).isEqualTo(true);
        assertThat(PointHandler.isSupports("1,2")).isEqualTo(false);
        assertThat(PointHandler.isSupports("-1,+2")).isEqualTo(false);
        assertThat(PointHandler.isSupports("-123")).isEqualTo(false);
        assertThat(PointHandler.isSupports("-")).isEqualTo(false);
        assertThat(PointHandler.isSupports("-+")).isEqualTo(false);
    }
}
