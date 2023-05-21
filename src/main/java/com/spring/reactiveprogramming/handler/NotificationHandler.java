package com.spring.reactiveprogramming.handler;

import com.spring.reactiveprogramming.client.NotificationRepository;
import com.spring.reactiveprogramming.domain.Notification;
import com.spring.reactiveprogramming.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequestMapping(path = "/notification")
public class NotificationHandler {

    @Autowired
    NotificationService notificationService;

    @Autowired
    private NotificationRepository notificationRepository;

    @GetMapping(value = "/get", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    Flux<Notification> getNotificationStream(){
        return notificationService.getNotificationsForUser("A");
    }

    @GetMapping(value = "/{name}")
    public Mono<Notification> getOne(@PathVariable UUID name) {
        return notificationRepository.findById(name);
    }
}
