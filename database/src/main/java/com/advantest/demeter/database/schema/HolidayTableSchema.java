package com.advantest.demeter.database.schema;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Create on 2025/01/01
 * Author: mengen.dai@outlook.com
 */
@Entity
@Table(name = "HOLIDAY_DB_TABLE")
public class HolidayTableSchema {

        @Id
        @Column(name = "ID", unique = true)
        private Long id;

        @Column(name = "HOLIDAY_NAME", columnDefinition = "varchar(255)", nullable = false)
        private String holidayName;

        @Column(name = "DESCRIPTION", columnDefinition = "text")
        private String description;

        @Column(name = "HOLIDAY_DATE", columnDefinition = "date", nullable = false)
        private LocalDate holidayDate;

        @Column(name = "HOLIDAY_TYPE", nullable = false)
        private Integer holidayType;

        @Column(name = "IS_RECURRING", columnDefinition = "tinyint(1) default 0", nullable = false)
        private Boolean isRecurring;

        @Column(name = "COUNTRY_CODE", nullable = false)
        private Integer countryCode;

        @Column(name = "CREATOR_ID", nullable = false)
        private Long creatorId;

        @Column(name = "UPDATER_ID")
        private Long updaterId;

        @Column(name = "CREATE_DATE_TIME", columnDefinition = "datetime DEFAULT '2022-10-08 00:00:00'", nullable = false)
        private LocalDateTime createDateTime;

        @Column(name = "UPDATE_DATE_TIME", columnDefinition = "datetime")
        private LocalDateTime updateDateTime;
}
