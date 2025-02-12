package com.advantest.demeter.api.vo;

import com.advantest.demeter.authentication.dto.LoginResponseDTO;

public record LoginResponseVO(
        String token,
        String employeeId,
        String employeeName
) {

    public static LoginResponseVO defaultValue() {
        return new LoginResponseVO("null", "null", "null");
    }

    public static LoginResponseVO from(LoginResponseDTO loginResponseDTO) {
        String token = loginResponseDTO.accessToken();
        String employeeName = loginResponseDTO.employeeName();
        String employeeId = loginResponseDTO.employeeId().toString();
        return new LoginResponseVO(token, employeeId, employeeName);
    }
}
