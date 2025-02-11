package com.advantest.demeter.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * Create on 2025/01/01
 * Author: mengen.dai@outlook.com
 */
@Data
@Builder
@AllArgsConstructor
public class LoginFormDTO {
    private String username;
    private String password;
}
