package com.advantest.demeter.common.constants;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Create on 2025/01/01
 * Author: mengen.dai@outlook.com
 */
public enum CountryCode {
    CHINA(1),
    JAPAN(2),
    AMERICA(3),
    GERMANY(4);

    private final int value;

    CountryCode(int value) {
        this.value = value;
    }

    @JsonValue
    public int toInt() {
        return value;
    }

    public static CountryCode fromInt(int value) {
        return switch (value) {
            case 1 -> CHINA;
            case 2 -> JAPAN;
            case 3 -> AMERICA;
            case 4 -> GERMANY;
            default -> throw new IllegalArgumentException(String.format("Invalid country value: %d. Valid values are: 1 (CHINA), 2 (JAPAN), 3 (AMERICA), 4 (GERMANY).", value));
        };
    }
}
