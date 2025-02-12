package com.advantest.demeter.service.handler;

import com.advantest.demeter.authentication.details.EmployeeDetails;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * Create on 2025/01/01
 * Author: mengen.dai@outlook.com
 */
@Component
@RequiredArgsConstructor
public class MetaFieldAutoFillHandler implements MetaObjectHandler {
    public static final String CREATE_TIME = "createTime";
    public static final String UPDATE_TIME = "updateTime";

    @Override
    public void insertFill(MetaObject metaObject) {
        Optional<Long> optional = this.getCurrentEmployeeId();
        optional.ifPresent(employeeId -> this.strictInsertFill(metaObject, "creatorId", Long.class, employeeId));
        this.strictInsertFill(metaObject, CREATE_TIME, LocalDateTime.class, LocalDateTime.now());
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        Optional<Long> optional = this.getCurrentEmployeeId();
        optional.ifPresent(employeeId -> this.strictUpdateFill(metaObject, "updaterId", Long.class, employeeId));
        this.strictUpdateFill(metaObject, UPDATE_TIME, LocalDateTime.class, LocalDateTime.now());
    }

    private Optional<Long> getCurrentEmployeeId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Optional<EmployeeDetails> optional = EmployeeDetails.parse(authentication.getPrincipal());
        return optional.map(EmployeeDetails::getEmployeeId);
    }
}
