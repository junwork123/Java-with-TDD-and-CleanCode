package org.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;


public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp(){
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
    }

    @Test @DisplayName("콜렉션 사이즈 반환")
    void size(){
        assertThat(numbers.size()).isEqualTo(4);
    }

    //@Test : ParameterizedTest를 사용할 때는 @Test는 지워야 한다
    @ParameterizedTest @DisplayName("요소 존재여부 확인")
    @ValueSource(ints = {1,2,3,4})
    void contains(int item){
        assertThat(numbers).contains(item);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "5:false", "6:false"}, delimiter = ':')
    void contain2(int input, boolean expected){
        
    }
}
