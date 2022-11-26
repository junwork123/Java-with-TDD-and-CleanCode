package org.calculator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class CalculatorTest {
    Calculator cal;
    Scanner sc;
    String getTestInput(String input){
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
    @BeforeEach
    public void setUp()  {
        cal = new Calculator();

        // 출력 설정
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
    }

    @AfterEach
    public void tearDown() {
        cal = null;
    }
//
//    @Test
//    public void 덧셈()  {
//        assertEquals(7, cal.add(3, 4));
//    }
//
//    @Test
//    public void 뺄셈()  {
//        assertEquals(1, cal.subtract(5,  4));
//    }
//
//    @Test
//    public void 곱셉()  {
//        assertEquals(6, cal.multiply(2, 3));
//    }
//
//    @Test
//    public void 나눗셈()  {
//        assertEquals(2, cal.divide(8, 4));
//    }

    @ParameterizedTest(name = "문자열 입력 테스트")
    @ValueSource(strings = {"1 + 2", "1 - 2", "1 * 2", "1 / 2"})
    public void 문자열_입력_2항(String input){
        Map<String, List<String>> resultMap = cal.parse(input);
    }

    @ParameterizedTest(name = "문자열 입력 테스트 실패")
    @ValueSource(strings = {"123", "1 2", "1  2", "1 q 2", "1 2 3"})
    public void 문자열_입력_실패(String input){
        Map<String, List<String>> resultMap = cal.parse(input);
    }

    @ParameterizedTest(name = "문자열 계산 테스트")
    @ValueSource(strings = {"1 + 2", "1 - 2", "1 * 2", "1 / 2"})
    public void 문자열_계산(String input){
        double result = cal.calculate(input);
    }

}