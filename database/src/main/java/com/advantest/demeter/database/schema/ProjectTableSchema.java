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
public record ProjectTableSchema(
        @Id
        @Column(name = "ID", unique = true)
        Long id,

        @Column(name = "PROJECT_NAME", columnDefinition = "varchar(255)", nullable = false)
        String projectName,

        @Column(name = "DESCRIPTION", columnDefinition = "text")
        String description,

        @Column(name = "START_DATE_TIME", columnDefinition = "varchar(10)", nullable = false)
        String startDateTime,

        @Column(name = "END_DATE_TIME", columnDefinition = "varchar(10)")
        String endDateTime,

        @Column(name = "PROJECT_STATUS", nullable = false)
        Integer projectStatus,

        @Column(name = "VERSION")
        Integer version,

        @Column(name = "`ORDER`")
        Integer order,

        @Column(name = "CREATOR_ID", nullable = false)
        Long creatorId,

        @Column(name = "UPDATER_ID")
        Long updaterId,

        @Column(name = "CREATE_DATE_TIME", columnDefinition = "varchar(26) DEFAULT '2025-01-01 00:00:00'", nullable = false)
        LocalDateTime createDateTime,

        @Column(name = "UPDATE_DATE_TIME", columnDefinition = "varchar(26)")
        LocalDateTime updateDateTime
) {
}
