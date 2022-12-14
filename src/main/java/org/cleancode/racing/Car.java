package org.cleancode.racing;

public class Car {
    private final Name name;
    private Position position;

    public Car(final String name) {
        this(name, 0);
    }

    public Car(final String name, int position){
        this.name = new Name(name);
        this.position = new Position(position);
    }

    public Name getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }

    public void displayResult(){
        System.out.println(this.getName() + " : " + "-".repeat(this.getPosition().getDistance()));
    }

    public Position move(MovingStrategy strategy){
        if(strategy.movable()){
            position = position.move(1);
        }
        return position;
    }
}
