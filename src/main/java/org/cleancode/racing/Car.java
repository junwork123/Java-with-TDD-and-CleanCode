package org.cleancode.racing;

public class Car {
    public static final int OIL_THRESHOLD = 4;
    public static final int DEFAULT_DISTANCE = 1;
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = DEFAULT_DISTANCE;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public int move(int oil){
        if(oil >= OIL_THRESHOLD){
            this.position++;
        }
        return position;
    }
}
