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
@Table(name = "PROJECT_TASK_DB_TABLE")
public record ProjectTaskTableSchema(
        @Id
        @Column(name = "ID", unique = true)
        Long id,

        @Column(name = "TASK_NAME", columnDefinition = "varchar(255)", nullable = false)
        String taskName,

        @Column(name = "PARENT_TASK_ID")
        Long parentTaskId,

        @Column(name = "PROJECT_ID", nullable = false)
        Long projectId,

        @Column(name = "`ORDER`")
        Long order,

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
