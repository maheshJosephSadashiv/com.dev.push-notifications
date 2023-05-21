package com.spring.reactiveprogramming.service;

import com.spring.reactiveprogramming.domain.Notification;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;

@Service
public class NotificationService {

    public Flux<Notification> getNotificationsForUser(String userId) {
        return getNotification();
    }

    private static Flux<Notification> getNotification(){
        return Flux.range(1,10)
                .delayElements(Duration.ofSeconds(1))
                .map(i -> new Notification("notification "+i, "90000"+i,"mobile",false, Notification.Priority.MEDIUM));
    }
}
