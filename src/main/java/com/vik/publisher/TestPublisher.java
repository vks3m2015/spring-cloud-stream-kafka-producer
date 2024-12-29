package com.vik.publisher;

import com.vik.dto.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import reactor.core.publisher.EmitterProcessor;
import reactor.core.publisher.Flux;

import java.util.function.Supplier;

@Component
@RequiredArgsConstructor
public class TestPublisher {

   // private final EmitterProcessor<Message<Person>> testEmitterProcessor = EmitterProcessor.create();

    private final EmitterProcessor<Message<Customer>> testEmitterProcessor = EmitterProcessor.create();

    /*public void publishEvent(Person person){
        MessageBuilder<Person> builder = MessageBuilder.withPayload(person);
        Message<Person> message = builder.build();
        testEmitterProcessor.onNext(message);
    }*/

    public void publishEvent(Customer customer){
        MessageBuilder<Customer> builder = MessageBuilder.withPayload(customer);
        Message<Customer> message = builder.build();
        testEmitterProcessor.onNext(message);
    }

   /* public void publishEvent(String str){
        MessageBuilder<String> builder = MessageBuilder.withPayload(str);
        Message<String> message = builder.build();
        testEmitterProcessor.onNext(message);
        System.out.println("message published");
    }*/

    /*@Bean
    public Supplier<Flux<Message<Person>>> publishEventBean(){
        return () -> testEmitterProcessor;
    }*/

    @Bean
    public Supplier<Flux<Message<Customer>>> publishEventBean(){
        return () -> testEmitterProcessor;
    }
}
