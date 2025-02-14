package com.advantest.demeter.service.constants;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Create on 2025/01/01
 * Author: mengen.dai@outlook.com
 */
public enum ProjectTaskStatus {
    NOT_STARTED(1),
    IN_PROGRESS(2),
    ACCEPTANCE(3),
    COMPLETED(4),
    ON_HOLD(5),
    CANCELED(6);

    private final int value;

    ProjectTaskStatus(int value) {
        this.value = value;
    }

    @JsonValue
    public int toInt() {
        return this.value;
    }

    public static ProjectTaskStatus fromInt(int field) {
        return switch (field) {
            case 1 -> NOT_STARTED;
            case 2 -> IN_PROGRESS;
            case 3 -> ACCEPTANCE;
            case 4 -> COMPLETED;
            case 5 -> ON_HOLD;
            case 6 -> CANCELED;
            default ->
                    throw new IllegalArgumentException("Invalid ProjectTaskStatus field: " + field + ". Valid fields are 1 (NotStarted), 2 (InProgress), 3 (Acceptance), 4 (Completed), 5 (OnHold), 6 (Canceled).");
        };
    }
}
