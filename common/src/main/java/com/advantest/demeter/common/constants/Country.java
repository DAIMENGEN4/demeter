package com.advantest.demeter.common.constants;

/**
 * Create on 2025/01/01
 * Author: mengen.dai@outlook.com
 */
public enum Country {
    CHINA(1),
    JAPAN(2),
    AMERICA(3),
    GERMANY(4);

    private final int value;

    Country(int value) {
        this.value = value;
    }

    public int toInt() {
        return value;
    }

    public static Country fromInt(int value) {
        for (Country country : Country.values()) {
            if (country.toInt() == value) {
                return country;
            }
        }
        throw new IllegalArgumentException(String.format("Invalid country value: %d. Valid values are: %d (CHINA), %d (JAPAN), %d (AMERICA), %d (GERMANY).", value, 1, 2, 3, 4));
    }
}
