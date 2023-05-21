package com.spring.reactiveprogramming;

import org.junit.jupiter.api.Test;
import org.reactivestreams.Subscriber;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class ReactiveWebFlux {
/*
THE SPECIFICATION
1. Subscribe to the PUBLISHER
2. PUBLISHER sends the subscription
3. SUBSCRIBER request(n)
5. OnNext(1) -> OnNext(n)
6. OnComplete/OnError
 */
    @Test
    public void monoSuccessTest(){
        //creating a Mono object use .just that handles only one object in this case a String object
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

    @Test
    public void testFlux(){
        Flux<String> fluxString = Flux.just("String1", "String2", "String3", "String4", "String5")
                .log();
        fluxString.subscribe(System.out::println);
    }

    @Test
    public void testFluxOnError(){
        Flux<?> fluxString = Flux.just("String1", "String2", "String3", "String4", "String5")
                .concatWithValues("bob")
                .concatWith(Flux.error(new RuntimeException("Error in flux")))
                .log();
        fluxString.subscribe(System.out::println, throwable -> System.out.println(throwable.getMessage()));
    }

    //Asynchronous and unblocking

}
