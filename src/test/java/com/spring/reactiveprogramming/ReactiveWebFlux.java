package com.spring.reactiveprogramming;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public class ReactiveWebFlux {

    @Test
    public void monoSuccessTest(){
        Mono<String> monoString = Mono.just("This is a test!").log();
        monoString.subscribe(System.out::println);
    }

    @Test
    public void monoWithErrorTest(){
        Mono<?> monoString = Mono.just("This is a test!")
                .then(Mono.error(new RuntimeException("An Exception has occurred")))
                .log();
        monoString.subscribe(System.out::println, throwable -> {
            System.out.println(throwable.getMessage());
        });
    }

}
