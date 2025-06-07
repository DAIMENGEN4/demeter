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
public class ProjectTaskTableSchema {

        @Id
        @Column(name = "ID", unique = true)
        private Long id;

        @Column(name = "TASK_NAME", columnDefinition = "varchar(255)", nullable = false)
        private String taskName;

        @Column(name = "PARENT_TASK_ID")
        private Long parentTaskId;

        @Column(name = "PROJECT_ID", nullable = false)
        private Long projectId;

        @Column(name = "`ORDER`")
        private Integer order;

        @Column(name = "CREATOR_ID", nullable = false)
        private Long creatorId;

        @Column(name = "UPDATER_ID")
        private Long updaterId;

        @Column(name = "CREATE_DATE_TIME", columnDefinition = "datetime DEFAULT '2022-10-08 00:00:00'", nullable = false)
        private LocalDateTime createDateTime;

        @Column(name = "UPDATE_DATE_TIME", columnDefinition = "datetime")
        private LocalDateTime updateDateTime;
}
