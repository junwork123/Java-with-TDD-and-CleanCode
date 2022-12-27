package org.cleancode.calculator.calcuable;

import java.util.Arrays;

public enum Operator {
    ADD("+"),
    SUBTRACT("-"),
    MULTIPLY("*"),
    DIVIDE("/");

    private final String ops;

    Operator(String ops) {
        this.ops = ops;
    }

    public String getOps() {
        return ops;
    }
    public static Operator of(String ops){
        return Arrays.stream(Operator.values())
                .filter(item -> item.getOps().equals(ops))
                .findFirst()
                .orElseThrow();
    }
}
