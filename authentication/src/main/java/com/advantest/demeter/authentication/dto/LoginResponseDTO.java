package com.advantest.demeter.authentication.dto;

public record LoginResponseDTO(
        String accessToken,
        String refreshToken,
        Long employeeId,
        String employeeName) {

}
