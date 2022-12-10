package org.cleancode.racing.deprecated;

import java.util.Random;

public class NumberGenerator {
    public static int getRandomNumber(){
        return new Random().nextInt(9);
    }
}
