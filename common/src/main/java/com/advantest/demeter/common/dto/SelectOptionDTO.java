package com.advantest.demeter.common.dto;

/**
 * Create on 2025/01/01
 * Author: mengen.dai@outlook.com
 */
public record SelectOptionDTO<T>(
        String label,
        T value
) {

}
