package org.cleancode.racing;

import java.util.Objects;

public class Name {
    public static final int MAX_NAME_LENGTH = 5;
    private final String name;
    public Name(String name) {
        if(name.length() > MAX_NAME_LENGTH){
            throw new IllegalArgumentException("이름은 " + MAX_NAME_LENGTH + "글자를 초과할 수 없습니다");
        }
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name1 = (Name) o;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(MAX_NAME_LENGTH, name);
    }
}
