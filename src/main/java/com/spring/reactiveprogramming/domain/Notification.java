package com.spring.reactiveprogramming.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor

public class Notification {
    private String body;
    private String userId;
    private String tenant;
    private Boolean hasRead;
    private Priority priority;
    public enum Priority {
        CRITICAL,
        HIGH,
        MEDIUM,
        LOW
    }
}
