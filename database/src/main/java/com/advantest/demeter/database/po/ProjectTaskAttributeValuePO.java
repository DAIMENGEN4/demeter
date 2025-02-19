package com.advantest.demeter.database.po;

import java.time.LocalDateTime;

/**
 * Create on 2025/01/01
 * Author: mengen.dai@outlook.com
 */
public interface ProjectTaskAttributeValuePO<T> {
    Long getId();
    Long getTaskId();
    Long getTaskAttributeId();
    T getTaskAttributeValue();
    Long getProjectId();
    Long getCreatorId();
    Long getUpdaterId();
    LocalDateTime getCreateDateTime();
    LocalDateTime getUpdateDateTime();
}
