package com.advantest.demeter.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Create on 2025/02/11
 * Author: mengen.dai@advantest.com
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginFormDTO {
    private String username;
    private String password;
}
