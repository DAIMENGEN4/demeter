package com.advantest.demeter.authentication.dto;

public record LoginResponseDTO(
        String token,
        Long employeeId,
        String employeeName) {

}
