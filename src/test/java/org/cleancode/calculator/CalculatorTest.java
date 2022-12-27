package org.cleancode.calculator;

import org.cleancode.calculator.calcuable.Number;
import org.cleancode.calculator.calcuable.Operator;
import org.cleancode.calculator.handler.NumberHandler;
import org.cleancode.calculator.handler.OperatorHandler;
import org.cleancode.calculator.handler.StringParser;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {
    Calculator calculator;

    @BeforeEach
    public void setUp()  {
        calculator = new Calculator();

        // 출력 설정
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
    }

    @AfterEach
    public void tearDown() {
        calculator = null;
    }
    @Test
    public void 덧셈()  {
        assertEquals(new Number(10), new Number(5).add(new Number(5)));
    }
    @Test
    public void 뺄셈()  {
        assertEquals(new Number(0), new Number(5).subtract(new Number(5)));
    }
    @Test
    public void 곱셈()  {
        assertEquals(new Number(25), new Number(5).multiply(new Number(5)));
    }
    @Test
    public void 나눗셈()  {
        assertEquals(new Number(1), new Number(5).divide(new Number(5)));
    }
    @Test
    public void 숫자_판별(){
        assertThat(NumberHandler.supports("123")).isEqualTo(true);
        assertThat(NumberHandler.supports("+123")).isEqualTo(true);
        assertThat(NumberHandler.supports("1q2w3e4r")).isEqualTo(false);
        assertThat(NumberHandler.supports("--123")).isEqualTo(false);
        assertThat(NumberHandler.supports("-123+")).isEqualTo(false);
        assertThat(NumberHandler.supports("-")).isEqualTo(false);
        assertThat(NumberHandler.supports("-+")).isEqualTo(false);
    }
    @Test
    public void 연산자_판별(){
        assertThat(OperatorHandler.supports("+")).isEqualTo(true);
        assertThat(OperatorHandler.supports("+-")).isEqualTo(false);
        assertThat(OperatorHandler.supports("+-/*")).isEqualTo(false);
        assertThat(OperatorHandler.supports("qwe")).isEqualTo(false);
        assertThat(OperatorHandler.supports("~")).isEqualTo(false);
    }

    @ParameterizedTest(name = "문자열 입력 테스트")
    @ValueSource(strings = {"1 + 2", "1 - 2", "1 * 2", "1 / 2"})
    public void 문자열_입력_2항(String input){
        List<Number> numbers = StringParser.parseNumbers(input);
        List<Operator> ops = StringParser.parseOperators(input);

        assertThat(numbers.size()).isEqualTo(2);
        assertThat(numbers.get(0)).isEqualTo(new Number(1));
        assertThat(numbers.get(1)).isEqualTo(new Number(2));
        assertThat(ops.size()).isEqualTo(1);
        assertThat(ops.get(0)).isEqualTo(Operator.of(input.split(" ")[1]));
    }

    @ParameterizedTest(name = "문자열 입력 테스트 실패")
    @ValueSource(strings = {"123", "1 2", "1  2", "1 q 2", "1 2 3"})
    public void 문자열_입력_실패(String input){
        assertThatThrownBy( () -> {
            StringParser.parseNumbers(input);
            StringParser.parseOperators(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "문자열 계산 테스트")
    @CsvSource(value = {"1 + 2:3", "1 - 2:-1", "1 * 2:2", "1 / 2:0"}, delimiter = ':')
    public void 문자열_계산(String input, Number expected){
        Number result = calculator.calculate(input);

        assertThat(result).isEqualTo(expected);
    }

}