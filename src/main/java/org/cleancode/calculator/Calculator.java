package org.cleancode.calculator;

import org.cleancode.calculator.calcuables.NumberOperator;
import org.cleancode.calculator.calcuables.PointOperator;
import org.cleancode.calculator.calcuables.interfaces.Operable;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

public class Calculator {
    private final List<Operable> operators;

    public Calculator() {
        this.operators = new ArrayList<>();
        operators.addAll(List.of(NumberOperator.values()));
        operators.addAll(List.of(PointOperator.values()));
    }
    private Operable match(String input){
        return operators.stream()
                .filter(op -> Operable.isMatch(op, input))
                .findFirst().orElseThrow();
    }
    private List<String> split(Operable op, String input){
        Matcher matcher = Operable.getPattern(op).matcher(input);
        List<String> result = new ArrayList<>();
        if(!matcher.find()){
            throw new IllegalArgumentException();
        }
        for (int i = 1; i <= matcher.groupCount(); i+=2) {
            result.add(matcher.group(i));
        }
        return result;
    }
    private Result calculate(Operable op, List<String> items){
        if(op.getHowMany() != items.size()){
            throw new IllegalArgumentException("항의 갯수가 적절하지 않습니다.");
        }
        return new Result(op, items, op.apply(items));
    }
    private String print(Result result){
        return result.getResult();
        // print
    }
    public String calculate(String input){
        Operable op = match(input);
        List<String> items = split(op, input);
        Result result = calculate(op, items);
        return print(result);
    }

    private class Result{
        private final Operable op;
        private final List<String> items;
        private final String result;

        public Result(Operable op, List<String> items, String result) {
            this.op = op;
            this.items = items;
            this.result = result;
        }

        public Operable getOp() {
            return op;
        }

        public List<String> getItems() {
            return items;
        }

        public String getResult() {
            return result;
        }
    }
}
