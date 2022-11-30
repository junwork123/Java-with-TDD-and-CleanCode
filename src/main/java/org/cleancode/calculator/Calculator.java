package org.cleancode.calculator;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * 사용자가 입력한 문자열 값에 따라 사칙연산을 수행할 수 있는 계산기를 구현해야 한다.
 * 문자열 계산기는 사칙연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정된다.
 * 즉, 수학에서는 곱셈, 나눗셈이 덧셈, 뺄셈 보다 먼저 계산해야 하지만 이를 무시한다.
 * 예를 들어 "2 + 3 * 4 / 2"와 같은 문자열을 입력할 경우 2 + 3 * 4 / 2 실행 결과인 10을 출력해야 한다.
 */
public class Calculator {
    final Pattern NUMBER_PATTERN = Pattern.compile("^[-+]?[0-9]+$");
    final Pattern OPERATOR_PATTERN = Pattern.compile("^[-+/*]{1}$");

    public int add(int a, int b) {
        return a + b;
    }
    public int subtract(int a, int b) {
        return a - b;
    }
    public int multiply(int a, int b) {
        return a * b;
    }
    public int divide(int a, int b) {
        return a / b;
    }
    public boolean isNumber(String item){
        Matcher matcher = NUMBER_PATTERN.matcher(item);
        return matcher.matches();
    }

    public boolean isOperator(String item){
        Matcher matcher = OPERATOR_PATTERN.matcher(item);
        return matcher.matches();
    }

    Map<String, List<String>> parse(String input){
        String[] split = input.split(" ");
        List<String> numbers = Arrays.stream(split)
                .filter(this::isNumber)
                .collect(Collectors.toList());
        List<String> ops = Arrays.stream(split)
                .filter(this::isOperator)
                .collect(Collectors.toList());

        if (numbers.isEmpty() || ops.isEmpty()){
            throw new IllegalArgumentException("잘못된 계산식입니다.");
        }

        Map<String, List<String>> result = new HashMap<>();
        result.put("numbers", numbers);
        result.put("ops", ops);

        return result;
    }

    public int calculate(int x, int y, String op){
        int result;
        switch (op){
            case "+": result = add(x,y); break;
            case "-": result = subtract(x,y); break;
            case "*": result = multiply(x,y); break;
            case "/": result = divide(x,y); break;
            default: throw new IllegalArgumentException("잘못된 연산자입니다.");
        }
        return result;
    }
    public int calculate(String input){
        Map<String, List<String>> map = parse(input);
        List<String> numbers = map.get("numbers");
        List<String> ops = map.get("ops");

        int result = 0, x = 0, y = 0;
        for(String op : ops){
            x = Integer.parseInt(numbers.remove(0));
            y = Integer.parseInt(numbers.remove(0));
            result += calculate(x,y,op);
        }

        return result;
    }
}
