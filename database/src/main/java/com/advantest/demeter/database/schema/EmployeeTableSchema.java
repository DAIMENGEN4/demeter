package com.advantest.demeter.database.schema;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

/**
 * Create on 2025/01/01
 * Author: mengen.dai@outlook.com
 */
@Entity
@Table(name = "EMPLOYEE_DB_TABLE")
public record EmployeeTableSchema(
        @Id
        @Column(name = "ID", unique = true)
        Long id,

        @Column(name = "USERNAME", columnDefinition = "varchar(255)", nullable = false)
        String username,

        @Column(name = "PASSWORD", columnDefinition = "varchar(255)", nullable = false)
        String password,

        @Column(name = "EMPLOYEE_NAME", columnDefinition = "varchar(255)", nullable = false)
        String employeeName,

        @Column(name = "EMAIL", columnDefinition = "varchar(255)", nullable = false)
        String email,

        @Column(name = "PHONE", columnDefinition = "varchar(15)")
        String phone,

        @Column(name = "IS_ACTIVE", columnDefinition = "tinyint(1)  default 0", nullable = false)
        Boolean isActive,

        @Column(name = "CREATOR_ID", nullable = false)
        Long creatorId,

        @Column(name = "UPDATER_ID")
        Long updaterId,

        @Column(name = "CREATE_DATE_TIME", columnDefinition = "datetime DEFAULT '2022-10-08 00:00:00'", nullable = false)
        LocalDateTime createDateTime,

        @Column(name = "UPDATE_DATE_TIME", columnDefinition = "datetime")
        LocalDateTime updateDateTime
) {
}
