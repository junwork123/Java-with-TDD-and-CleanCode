package org.calculator;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    int add(int a, int b) {
        return a + b;
    }
    int subtract(int a, int b) {
        return a - b;
    }
    int multiply(int a, int b) {
        return a * b;
    }
    int divide(int a, int b) {
        return a / b;
    }
    String[] inputString(Scanner sc){
        String input = sc.nextLine();
        return input.split(" ");
    }
    void parse(String[] split){
        Pattern patternInt = Pattern.compile("[-|+][0-9]+");

        for(String item : split){
            Matcher matcher = patternInt.matcher(item);
            if(matcher.matches()){
                int parseInt = Integer.parseInt(item);
            }
        }

    }
}
