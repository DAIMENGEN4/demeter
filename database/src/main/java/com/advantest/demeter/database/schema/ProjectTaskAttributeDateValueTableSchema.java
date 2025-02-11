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
@Table(name = "PROJECT_TASK_ATTRIBUTE_DATE_VALUE_DB_TABLE")
public record ProjectTaskAttributeDateValueTableSchema(
        @Id
        @Column(name = "ID", unique = true)
        Long id,

        @Column(name = "TASK_ID", nullable = false)
        Long taskId,

        @Column(name = "TASK_ATTRIBUTE_ID", nullable = false)
        Long taskAttributeId,

        @Column(name = "TASK_ATTRIBUTE_VALUE", columnDefinition = "varchar(10)", nullable = false)
        String taskAttributeValue,

        @Column(name = "PROJECT_ID", nullable = false)
        Long projectId,

        @Column(name = "CREATOR_ID", nullable = false)
        Long creatorId,

        @Column(name = "UPDATER_ID", nullable = false)
        Long updaterId,

        @Column(name = "CREATE_DATE_TIME", columnDefinition = "varchar(19) DEFAULT '2025-01-01 00:00:00'", nullable = false)
        LocalDateTime createDateTime,

        @Column(name = "UPDATE_DATE_TIME", columnDefinition = "varchar(19)")
        LocalDateTime updateDateTime
) {
}
