package org.cleancode.calculator;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    private final Calculator calculator = new Calculator();

    @Test
    public void calculate_Number(){
        assertThat(calculator.calculate("1+2")).isEqualTo("3");
        assertThat(calculator.calculate("1-2")).isEqualTo("-1");
        assertThat(calculator.calculate("1*2")).isEqualTo("2");
        assertThat(calculator.calculate("1/2")).isEqualTo("0");
    }
    @Test
    public void calculate_Point(){
        assertThat(calculator.calculate("(1,2)+(3,4)")).isEqualTo("(4,6)");
        assertThat(calculator.calculate("(1,2)-(3,4)")).isEqualTo("(-2,-2)");
    }
}
