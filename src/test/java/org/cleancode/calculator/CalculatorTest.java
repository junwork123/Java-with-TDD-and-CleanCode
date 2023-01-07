package org.cleancode.calculator;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    private final Calculator calculator = new Calculator();

    @Test
    public void calculate_Number(){
        assertThat(calculator.calculate("1+2")).isEqualTo("3.0");
        assertThat(calculator.calculate("1-2")).isEqualTo("-1.0");
        assertThat(calculator.calculate("1*2")).isEqualTo("2.0");
        assertThat(calculator.calculate("1/2")).isEqualTo("0.0");
    }
    @Test
    public void calculate_Point(){
        assertThat(calculator.calculate("(1,2)+(3,4)")).isEqualTo("(4.0,6.0)");
        assertThat(calculator.calculate("(1,2)-(3,4)")).isEqualTo("(-2.0,-2.0)");
        assertThat(calculator.calculate("(1,2)<->(3,4)")).isEqualTo("2.0"); // distance
    }
}
