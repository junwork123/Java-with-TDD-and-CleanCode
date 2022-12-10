package org.cleancode.racing;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class PositionTest {
    @Test
    public void create(){
        Position position = new Position(3);
        assertThat(position).isEqualTo(new Position(3));
    }

    @Test
    public void valid(){
        assertThatThrownBy(() -> {
            new Position(-1);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void move(){
        Position p = new Position(3);
        assertThat(p.move(1)).isEqualTo(new Position(4));
    }
}
