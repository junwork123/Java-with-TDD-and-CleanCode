package org.cleancode.calculator;

import org.cleancode.calculator.calcuable.Number;
import org.cleancode.calculator.calcuable.Operator;
import org.cleancode.calculator.handler.StringParser;

import java.util.List;

public class Calculator {

    private Number calculate(Number x, Number y, Operator op){
        Number result;
        switch (op){
            case ADD: result = x.add(y); break;
            case SUBTRACT: result = x.subtract(y); break;
            case MULTIPLY: result = x.multiply(y); break;
            case DIVIDE: result = x.divide(y); break;
            default: throw new IllegalArgumentException("잘못된 연산자입니다.");
        }
        return result;
    }
    public Number calculate(String input){
        List<Number> numbers = StringParser.parseNumbers(input);
        List<Operator> ops = StringParser.parseOperators(input);

        Number result = new Number(0);
        for(Operator op : ops){
            result.add(calculate(numbers.remove(0),numbers.remove(0),op));
        }

        return result;
    }
}
