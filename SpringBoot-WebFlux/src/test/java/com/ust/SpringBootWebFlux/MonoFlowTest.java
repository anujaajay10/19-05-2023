package com.ust.SpringBootWebFlux;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class MonoFlowTest {
    @Test
    public void testMono(){
        Mono<?> monoString = Mono.just("javatechie")
       // .then(Mono.error(new RuntimeException("Exception accured")))
        .log();
        monoString.subscribe(System.out::println,(e)->System.out.println(e.getMessage()));
    }
    @Test
    public void testFlux(){
        Flux<String>fluxString= Flux.just("Sring","Spring Boot","Hibernate","Microservice")
                .concatWithValues("AWS")
                //.concateWith(Flux.error(new RuntimeException("Exception accured in Flux")))
                .concatWithValues("cloud")
                .log();
        fluxString.subscribe(System.out::println,(e)->System.out.println(e.getMessage()));
    }
}
