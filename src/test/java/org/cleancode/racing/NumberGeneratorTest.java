package org.cleancode.racing;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NumberGeneratorTest {
    NumberGenerator generator = new NumberGenerator();
    @Test
    void getRandomNumber() {
        int randomNumber = generator.getRandomNumber();

        assertThat(randomNumber)
                .isGreaterThanOrEqualTo(0)
                .isLessThanOrEqualTo(9);
    }
}