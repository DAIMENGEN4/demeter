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
@Table(name = "PROJECT_TASK_ATTRIBUTE_DATETIME_VALUE_DB_TABLE")
public class ProjectTaskAttributeDatetimeValueTableSchema {

        @Id
        @Column(name = "ID", unique = true)
        private Long id;

        @Column(name = "TASK_ID", nullable = false)
        private Long taskId;

        @Column(name = "TASK_ATTRIBUTE_ID", nullable = false)
        private Long taskAttributeId;

        @Column(name = "TASK_ATTRIBUTE_VALUE", columnDefinition = "datetime", nullable = false)
        private LocalDateTime taskAttributeValue;

        @Column(name = "PROJECT_ID", nullable = false)
        private Long projectId;

        @Column(name = "CREATOR_ID", nullable = false)
        private Long creatorId;

        @Column(name = "UPDATER_ID")
        private Long updaterId;

        @Column(name = "CREATE_DATE_TIME", columnDefinition = "datetime DEFAULT '2022-10-08 00:00:00'", nullable = false)
        private LocalDateTime createDateTime;

        @Column(name = "UPDATE_DATE_TIME", columnDefinition = "datetime")
        private LocalDateTime updateDateTime;
}
