package org.cleancode.coffeeshop.product;

import java.util.Arrays;

public enum Size {
    TALL(1),
    GRANDE(2),
    VENTI(3);

    private final int size;

    Size(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public static Size of(int size) {
        return Arrays.stream(Size.values())
                .filter(s -> s.getSize() == size)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("사이즈를 찾을 수 없습니다."));
    }


}
