package org.cleancode.racing;

import java.util.Random;

public class NumberGenerator {
    public int getRandomNumber(){
        return new Random().nextInt(9);
    }
}
