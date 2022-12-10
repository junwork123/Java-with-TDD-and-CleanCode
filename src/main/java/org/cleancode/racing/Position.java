package org.cleancode.racing;

import java.util.Objects;

public class Position implements Comparable {
    public static final int DEFAULT_DISTANCE = 1;
    private int distance;
    public Position(){
        this(DEFAULT_DISTANCE);
    }
    public Position(int distance) {
        if(distance < 0){
            throw new IllegalArgumentException("position은 음수 값을 가질 수 없습니다");
        }
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }

    public Position move(int toMove){
        // 조작할 일이 많이 없거나, 안정성(불변 상태) 우선인 경우
        // return new Position(position + toMove);

        // 성능(인스턴스 Garbage Collection 최소) 우선인 경우
        this.distance = this.distance + toMove;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position1 = (Position) o;
        return distance == position1.distance;
    }

    @Override
    public int hashCode() {
        return Objects.hash(distance);
    }

    @Override
    public int compareTo(Object o) {
        if(!(o instanceof Position)){
            throw new IllegalArgumentException("Position이 아닌 객체끼리는 비교할 수 없습니다.");
        }
        Position p = (Position) o;
        if(this.distance > p.getDistance()){
            return 1;
        }else if(this.distance < p.getDistance()){
            return -1;
        }
        return 0;
    }
}
