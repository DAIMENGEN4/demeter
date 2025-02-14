package com.advantest.demeter.authentication.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

public record LoginResponseDTO(
        String token,
        @JsonIgnore
        String refreshToken,
        Long employeeId,
        String employeeName) {
    public static LoginResponseDTO defaultValue() {
        return new LoginResponseDTO(
                "null",
                "null",
                0L,
                "null"
        );
    }
}
