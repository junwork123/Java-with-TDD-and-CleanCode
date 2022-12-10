package org.cleancode.racing;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class NameTest {

    @Test
    public void create(){
        Name name = new Name("test");
        assertThat(name).isEqualTo(new Name("test"));
    }

    @Test
    public void valid(){
        assertThatThrownBy(() -> {
            Name invalidName = new Name("0".repeat(Name.MAX_NAME_LENGTH + 1));
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
