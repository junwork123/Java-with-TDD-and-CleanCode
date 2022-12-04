package org.cleancode.baseballgame.object;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Balls {
    public final int MAX_COUNT = 3;
    private final String answer;
    public Balls(){
        answer = makeRandomAnswer();
    }
    public String getAnswer() {
        return answer;
    }
    private String makeRandomAnswer(){
        // 111~999까지 정수 반환
        // 0이 나오지 않도록 해야함
        // 서로 다른 수가 나와야 함
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
        int result = 0;
        for(int i=MAX_COUNT; i>0; i--){
            result += (numbers.remove(new Random().nextInt(numbers.size())) * (int) Math.pow(10, i));
        }
        return String.valueOf(result);
    }
}
