package com.spring.reactiveprogramming.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.sql.Timestamp;
import java.util.UUID;

@Data
@AllArgsConstructor

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
