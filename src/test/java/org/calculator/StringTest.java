package org.calculator;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test @DisplayName("문자열 내 특정 문자 교체")
    void replace(){
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test @DisplayName("특정 문자 기준 문자열 분리")
    void split(){
        String[] actual = "1,2".split(",");
        assertThat(actual.length).isEqualTo(2);
        assertThat(actual).contains("1");
        assertThat(actual).contains("2");
        assertThat(actual).containsExactly("1", "2");
    }

    @Test @DisplayName("부분 문자열 반환")
    void substring(){
        String actual = "(1,2)".substring(1, 4);
        assertThat(actual).isEqualTo("1,2");
    }

    @Test @DisplayName("부분 문자열 반환 중 Exception")
    void substring_Fail(){
        assertThatThrownBy( () -> {
            String actual = "(1,2)".substring(-1, Integer.MAX_VALUE);
        }).isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test @DisplayName("문자열 내 특정 문자 반환")
    void charAt(){
        char actual = "abc".charAt(1);
        assertThat(actual).isEqualTo('b');
    }

    @Test @DisplayName("문자열 내 특정 문자 반환 중 Exception")
    void charAt_Fail(){
        assertThatThrownBy(() -> {
            char actual = "abc".charAt(-1);
        }).isInstanceOf(IndexOutOfBoundsException.class);
    }
}
