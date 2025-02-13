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
        return switch (value) {
            case 1 -> NATIONAL_HOLIDAY;
            case 2 -> COMPANY_HOLIDAY;
            case 3 -> WEEKLY_HOLIDAY;
            case 4 -> SPECIAL_HOLIDAY;
            default -> throw new IllegalArgumentException(String.format("Invalid HolidayType field: %d. Valid values are: 1 (NATIONAL_HOLIDAY), 2 (COMPANY_HOLIDAY), 3 (WEEKLY_HOLIDAY), 4 (SPECIAL_HOLIDAY).", value));
        };
    }
}
