package com.spring.reactiveprogramming.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.sql.Timestamp;
import java.util.UUID;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(value = "notifications")
public class Notification {
    @Id
    private UUID id;
    private String body;
    private String userId;
    private String tenant;
    private Boolean hasRead;
    private Priority priority;
    private Timestamp createTime;
    private Timestamp readAt;
    public enum Priority {
        CRITICAL,
        HIGH,
        MEDIUM,
        LOW
    }
}
