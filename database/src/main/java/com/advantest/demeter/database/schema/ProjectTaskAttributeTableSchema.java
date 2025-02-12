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
@Table(name = "PROJECT_TASK_ATTRIBUTE_DB_TABLE")
public record ProjectTaskAttributeTableSchema(
        @Id
        @Column(name = "ID", unique = true)
        Long id,

        @Column(name = "TASK_ATTRIBUTE_NAME", columnDefinition = "varchar(255)", nullable = false)
        String taskAttributeName,

        @Column(name = "TASK_ATTRIBUTE_TYPE", columnDefinition = "varchar(20)", nullable = false)
        String taskAttributeType,

        @Column(name = "PROJECT_ID", nullable = false)
        Long projectId,

        @Column(name = "PROPERTIES", columnDefinition = "json")
        String properties,

        @Column(name = "`ORDER`", nullable = false)
        Integer order,

        @Column(name = "CREATOR_ID", nullable = false)
        Long creatorId,

        @Column(name = "UPDATER_ID")
        Long updaterId,

        @Column(name = "CREATE_DATE_TIME", columnDefinition = "varchar(19) DEFAULT '2025-01-01 00:00:00'", nullable = false)
        LocalDateTime createDateTime,

        @Column(name = "UPDATE_DATE_TIME", columnDefinition = "varchar(19)")
        LocalDateTime updateDateTime
) {
}
