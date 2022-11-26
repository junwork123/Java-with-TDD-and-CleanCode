package org.calculator;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Calculator {
    final Pattern NUMBER_PATTERN = Pattern.compile("[-+][0-9]+");
    final Pattern OPERATOR_PATTERN = Pattern.compile("[-+/*]");

    private int add(int a, int b) {
        return a + b;
    }
    private int subtract(int a, int b) {
        return a - b;
    }
    private int multiply(int a, int b) {
        return a * b;
    }
    private int divide(int a, int b) {
        return a / b;
    }
    private boolean isNumber(String item){
        Matcher matcher = NUMBER_PATTERN.matcher(item);
        if(matcher.matches()){
            return true;
        }
        return false;
    }

    private boolean isOperator(String item){
        Matcher matcher = NUMBER_PATTERN.matcher(item);
        if(matcher.matches()){
            return true;
        }
        return false;
    }

    Map<String, List<String>> parse(String input){
        String[] split = input.split(" ");
        List<String> numbers = Arrays.stream(split).filter(this::isNumber).toList();
        List<String> ops = Arrays.stream(split).filter(this::isOperator).toList();

        Map<String, List<String>> result = null;
        result.put("numbers", numbers);
        result.put("ops", ops);
        return result;
    }

    private double calculate(List<String> numbers, List<String> ops){
        return 0;
    }

    public double calculate(String input){
        Map<String, List<String>> map = parse(input);
        return calculate(map.get("numbers"), map.get("ops"));
    }
}
