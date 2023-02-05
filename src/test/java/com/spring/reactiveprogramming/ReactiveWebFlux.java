package com.spring.reactiveprogramming;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public class ReactiveWebFlux {

    @Test
    public void monoTest(){
        Mono<String> monoString = Mono.just("This is a test!").log();
        monoString.subscribe(System.out::println);
    }

}
