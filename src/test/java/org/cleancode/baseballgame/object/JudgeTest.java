package org.cleancode.baseballgame.object;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class JudgeTest {

    @ParameterizedTest
    @CsvSource(value = {"321:1", "123:3", "129:2", "189:1", "789:0", "723:2", "729:1", "783:1"}, delimiter = ':')
    void isStrike(String input, int expected) {
        assertThat(Judge.countStrikes(input, "123")).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"123:0", "321:2", "231:3", "789:0"}, delimiter = ':')
    void isBall(String input, int expected) {
        assertThat(Judge.countBalls(input, "123")).isEqualTo(expected);
    }

    @Test
    void validate() {
        assertThat(Judge.isValidLength("123")).isTrue();
        assertThat(Judge.isValidLength("1234")).isFalse();
        assertThat(Judge.isValidNumberFormat("123")).isTrue();
        assertThatThrownBy(() ->
            Judge.isValidNumberFormat("qwe123")
        ).isInstanceOf(NumberFormatException.class);
    }


}