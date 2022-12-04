package org.cleancode.baseballgame.object;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Ball {
    private final String answer;

    public String getAnswer() {
        return answer;
    }
    public Ball(){
        // 111~999까지 정수 반환
        // 0이 나오지 않도록 해야함
        // 서로 다른 수가 나와야 함
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
        int i__ = numbers.remove(new Random().nextInt(numbers.size()));
        int _i_ = numbers.remove(new Random().nextInt(numbers.size()));
        int __i = numbers.remove(new Random().nextInt(numbers.size()));
        answer = String.valueOf((i__ * 100) + (_i_ * 10) + __i);
    }
}
