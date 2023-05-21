package com.spring.reactiveprogramming.handler;

import com.spring.reactiveprogramming.domain.Notification;
import com.spring.reactiveprogramming.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping(path = "/notification")
public class NotificationHandler {

    @Autowired
    NotificationService notificationService;

    @GetMapping(value = "/get", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    Flux<Notification> getNotificationStream(){
        return notificationService.getNotificationsForUser("A");
    }
}
