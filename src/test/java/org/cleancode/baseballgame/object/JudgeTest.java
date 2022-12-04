package org.cleancode.baseballgame.object;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class JudgeTest {
    @ParameterizedTest
    @CsvSource(value = {"321:1", "123:3", "129:2", "189:1", "789:0", "723:2", "729:1", "783:1"}, delimiter = ':')
    void isStrike(String input, int expected) {
        assertThat(Judge.isStrike(input, "123")).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"123:0", "321:2", "231:3", "789:0"}, delimiter = ':')
    void isBall(String input, int expected) {
        assertThat(Judge.isBall(input, "123")).isEqualTo(expected);
    }
}