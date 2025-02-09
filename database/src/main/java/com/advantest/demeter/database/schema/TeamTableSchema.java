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
@Table(name = "TEAM_DB_TABLE")
public record TeamTableSchema(
        @Id
        @Column(name = "ID", unique = true)
        Long id,

        @Column(name = "TEAM_NAME", columnDefinition = "varchar(255)", nullable = false)
        String teamName,

        @Column(name = "DESCRIPTION", columnDefinition = "text")
        String description,

        @Column(name = "CREATOR_ID", nullable = false)
        Long creatorId,

        @Column(name = "UPDATER_ID", nullable = false)
        Long updaterId,

        @Column(name = "CREATE_DATE_TIME", columnDefinition = "varchar(19) DEFAULT '2025-01-01 00:00:00'", nullable = false)
        LocalDateTime createDateTime,

        @Column(name = "UPDATE_DATE_TIME", columnDefinition = "varchar(19) DEFAULT '2025-01-01 00:00:00'", nullable = false)
        LocalDateTime updateDateTime
) {
}
