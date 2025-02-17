package com.advantest.demeter.service.constants;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Create on 2025/01/01
 * Author: mengen.dai@outlook.com
 */
public enum ProjectStatus {
    NOT_STARTED("Not Started", 1),
    REQUIREMENTS_ANALYSIS("Requirements Analysis", 2),
    PLANNING("Planning", 3),
    IN_PROGRESS("In Progress", 4),
    ACCEPTANCE("Acceptance", 5),
    COMPLETED("Completed", 6),
    CANCELLED("Cancelled", 7),
    ON_HOLD("On Hold", 8),
    DELAYED("Delayed", 9);

    private final int value;
    private final String label;

    ProjectStatus(String label, int value) {
        this.label = label;
        this.value = value;
    }

    @JsonValue
    public int toInt() {
        return value;
    }

    public String toLabel() {
        return label;
    }

    public static ProjectStatus fromInt(int value) {
        return switch (value) {
            case 1 -> NOT_STARTED;
            case 2 -> REQUIREMENTS_ANALYSIS;
            case 3 -> PLANNING;
            case 4 -> IN_PROGRESS;
            case 5 -> ACCEPTANCE;
            case 6 -> COMPLETED;
            case 7 -> CANCELLED;
            case 8 -> ON_HOLD;
            case 9 -> DELAYED;
            default ->
                    throw new IllegalArgumentException(String.format("Invalid ProjectStatus value: %d. Valid values are: 1 (NOT_STARTED), 2 (REQUIREMENTS_ANALYSIS), 3 (PLANNING), 4 (IN_PROGRESS), 5 (ACCEPTANCE), 6 (COMPLETED), 7 (CANCELED), 8 (ON_HOLD), 9 (DELAYED).", value));
        };
    }
}
