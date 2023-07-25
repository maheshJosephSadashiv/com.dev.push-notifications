package com.spring.reactiveprogramming.client;

import com.spring.reactiveprogramming.domain.Notification;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.UUID;

@Repository
public interface NotificationRepository extends R2dbcRepository<Notification, UUID> {
    Flux<Notification> findByUserIdAndHasReadFalse(String userID);
}
