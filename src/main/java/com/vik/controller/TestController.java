package com.vik.controller;

import com.vik.dto.Customer;
import com.vik.publisher.TestPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//@RequiredArgsConstructor
@RestController
public class TestController {

    @Autowired
    private final TestPublisher testPublisher;

    public TestController(TestPublisher testPublisher) {
        this.testPublisher = testPublisher;
    }

    /*@PostMapping(path = "/test-pub", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void m(@RequestBody Person person){
        System.out.println(" inside publisher...");
        testPublisher.publishEvent(person);
    }*/

    @PostMapping(path = "/test-pub", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void m(@RequestBody Customer customer){
        System.out.println(" inside publisher...");
        testPublisher.publishEvent(customer);
    }

   /* @PostMapping(path = "/test-pub2", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void m2(@RequestBody String str){
        System.out.println(" inside publisher...");
        //testPublisher.publishEvent(str);
    }*/
}
