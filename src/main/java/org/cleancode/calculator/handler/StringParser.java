package org.cleancode.calculator.handler;

import org.cleancode.calculator.calcuable.Number;
import org.cleancode.calculator.calcuable.Operator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringParser {
    public static List<Number> parseNumbers(String input){
        List<Number> numbers = split(input)
                .filter(NumberHandler::supports)
                .map(Number::new)
                .collect(Collectors.toList());

        if (numbers.isEmpty()){
            throw new IllegalArgumentException("잘못된 계산식입니다.");
        }
        return numbers;
    }
    public static List<Operator> parseOperators(String input){
        List<Operator> ops = split(input)
                .filter(OperatorHandler::supports)
                .map(Operator::of)
                .collect(Collectors.toList());

        if (ops.isEmpty()){
            throw new IllegalArgumentException("잘못된 계산식입니다.");
        }
        return ops;
    }
    private static Stream<String> split(String input){
        return Arrays.stream(input.split(" "));
    }
}
