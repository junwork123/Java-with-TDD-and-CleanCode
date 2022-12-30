package org.cleancode.calculator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

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
}