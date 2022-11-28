package org.calculator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {
    Calculator calculator;
    Scanner sc;
    String getTestInput(String input){
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

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
        assertEquals(7, calculator.add(3, 4));
    }
    @Test
    public void 뺄셈()  {
        assertEquals(1, calculator.subtract(5,  4));
    }
    @Test
    public void 곱셉()  {
        assertEquals(6, calculator.multiply(2, 3));
    }
    @Test
    public void 나눗셈()  {
        assertEquals(2, calculator.divide(8, 4));
    }
    @Test
    public void 숫자_판별(){
        assertThat(calculator.isNumber("123")).isEqualTo(true);
        assertThat(calculator.isNumber("+123")).isEqualTo(true);
        assertThat(calculator.isNumber("1q2w3e4r")).isEqualTo(false);
        assertThat(calculator.isNumber("--123")).isEqualTo(false);
        assertThat(calculator.isNumber("-123+")).isEqualTo(false);
        assertThat(calculator.isNumber("-")).isEqualTo(false);
        assertThat(calculator.isNumber("-+")).isEqualTo(false);
    }
    @Test
    public void 연산자_판별(){
        assertThat(calculator.isOperator("+")).isEqualTo(true);
        assertThat(calculator.isOperator("+-")).isEqualTo(false);
        assertThat(calculator.isOperator("+-/*")).isEqualTo(false);
        assertThat(calculator.isOperator("qwe")).isEqualTo(false);
        assertThat(calculator.isOperator("~")).isEqualTo(false);
    }

    @ParameterizedTest(name = "문자열 입력 테스트")
    @ValueSource(strings = {"1 + 2", "1 - 2", "1 * 2", "1 / 2"})
    public void 문자열_입력_2항(String input){
        Map<String, List<String>> resultMap = calculator.parse(input);

        assertThat(resultMap.size()).isEqualTo(2);
        assertThat(resultMap.get("numbers").size()).isEqualTo(2);
        assertThat(resultMap.get("numbers").get(0)).isEqualTo("1");
        assertThat(resultMap.get("numbers").get(1)).isEqualTo("2");
        assertThat(resultMap.get("ops").size()).isEqualTo(1);
        assertThat(calculator.isOperator(resultMap.get("ops").get(0))).isEqualTo(true);
    }

    @ParameterizedTest(name = "문자열 입력 테스트 실패")
    @ValueSource(strings = {"123", "1 2", "1  2", "1 q 2", "1 2 3"})
    public void 문자열_입력_실패(String input){
        assertThatThrownBy( () -> {
            Map<String, List<String>> resultMap = calculator.parse(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "문자열 계산 테스트")
    @CsvSource(value = {"1 + 2:3", "1 - 2:-1", "1 * 2:2", "1 / 2:0"}, delimiter = ':')
    public void 문자열_계산(String input, int expected){
        int result = calculator.calculate(input);

        assertThat(result).isEqualTo(expected);
    }

}