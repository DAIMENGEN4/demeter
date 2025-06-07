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
@Table(name = "PROJECT_DB_TABLE")
public class ProjectTableSchema {

        @Id
        @Column(name = "ID", unique = true)
        private Long id;

        @Column(name = "PROJECT_NAME", columnDefinition = "varchar(255)", nullable = false)
        private String projectName;

        @Column(name = "DESCRIPTION", columnDefinition = "text")
        private String description;

        @Column(name = "START_DATE_TIME", columnDefinition = "varchar(10)", nullable = false)
        private String startDateTime;

        @Column(name = "END_DATE_TIME", columnDefinition = "varchar(10)")
        private String endDateTime;

        @Column(name = "PROJECT_STATUS", nullable = false)
        private Integer projectStatus;

        @Column(name = "VERSION")
        private Integer version;

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