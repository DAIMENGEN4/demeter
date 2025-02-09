package com.advantest.demeter.common.constants;

/**
 * Create on 2025/01/01
 * Author: mengen.dai@outlook.com
 */
public enum HolidayType {
    NATIONAL_HOLIDAY(1),
    COMPANY_HOLIDAY(2),
    WEEKLY_HOLIDAY(3),
    SPECIAL_HOLIDAY(4);

    private final int value;

    HolidayType(int value) {
        this.value = value;
    }

    public int toInt() {
        return value;
    }

    public static HolidayType fromInt(int value) {
        for (HolidayType type : values()) {
            if (type.value == value) {
                return type;
            }
        }
        throw new IllegalArgumentException(String.format("Invalid HolidayType field: %d. Valid values are: %d (NATIONAL_HOLIDAY), %d (COMPANY_HOLIDAY), %d (WEEKLY_HOLIDAY), %d (SPECIAL_HOLIDAY).", value, 1, 2, 3, 4));
    }
}
