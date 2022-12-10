package org.cleancode.racing;

public class Car {
    private final Name name;
    private Position position;

    public Car(String name) {
        this.name = new Name(name);
        this.position = new Position();
    }

    public Name getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }

    public Position move(MovingStrategy strategy){
        if(strategy.movable()){
            position = position.move(1);
        }
        return position;
    }
}
