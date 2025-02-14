package com.advantest.demeter.service.constants;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Create on 2025/01/01
 * Author: mengen.dai@outlook.com
 */
public enum ProjectStatus {
    NOT_STARTED(1),
    REQUIREMENTS_ANALYSIS(2),
    PLANNING(3),
    IN_PROGRESS(4),
    ACCEPTANCE(5),
    COMPLETED(6),
    CANCELED(7),
    ON_HOLD(8),
    DELAYED(9);

    private final int value;

    ProjectStatus(int value) {
        this.value = value;
    }

    @JsonValue
    public int toInt() {
        return value;
    }

    public static ProjectStatus fromInt(int value) {
        return switch (value) {
            case 1 -> NOT_STARTED;
            case 2 -> REQUIREMENTS_ANALYSIS;
            case 3 -> PLANNING;
            case 4 -> IN_PROGRESS;
            case 5 -> ACCEPTANCE;
            case 6 -> COMPLETED;
            case 7 -> CANCELED;
            case 8 -> ON_HOLD;
            case 9 -> DELAYED;
            default -> throw new IllegalArgumentException(String.format("Invalid ProjectStatus value: %d. Valid values are: 1 (NOT_STARTED), 2 (REQUIREMENTS_ANALYSIS), 3 (PLANNING), 4 (IN_PROGRESS), 5 (ACCEPTANCE), 6 (COMPLETED), 7 (CANCELED), 8 (ON_HOLD), 9 (DELAYED).", value));
        };
    }
}
