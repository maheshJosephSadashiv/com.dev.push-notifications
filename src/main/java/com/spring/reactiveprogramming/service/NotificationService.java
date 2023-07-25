package com.spring.reactiveprogramming.service;

import com.spring.reactiveprogramming.client.NotificationRepository;
import com.spring.reactiveprogramming.domain.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.sql.Timestamp;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class NotificationService {

    @Autowired
    NotificationRepository notificationRepository;

    public Flux<Notification> getNotificationsForUser(String userId) {
        return getNotification();
    }

    private static Flux<Notification> getNotification(){
        return Flux.range(1,10)
                .delayElements(Duration.ofSeconds(1))
                .map(i -> new Notification(UUID.randomUUID(),"notification "+i, "90000"+i,"mobile",false, Notification.Priority.MEDIUM, new Timestamp(Instant.now().getEpochSecond()), new Timestamp(Instant.now().getEpochSecond())));
    }
    public Flux<Notification> getNotificationByUserId(String userID) {
        var notifications = notificationRepository.findByUserIdAndHasReadFalse(userID);
//        notifications.forEach(x -> x.setHasRead(true));
//        notificationRepository.saveAll(notifications);
        return notifications;
    }

    public Flux<ServerSentEvent<Flux<Notification>>> getNotificationsByUserToID(String userID) {

            return Flux.interval(Duration.ofSeconds(1))
                    .publishOn(Schedulers.boundedElastic())
                    .map(sequence -> ServerSentEvent.<Flux<Notification>>builder().id(String.valueOf(sequence))
                            .event("user-list-event").data(getNotificationByUserId(userID))
                            .build());

    }
}
