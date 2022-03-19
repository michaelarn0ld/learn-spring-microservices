package io.michaelarnold.microservices.currencyexcahngeservice.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CircuitBreakerController {

    private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);

    @GetMapping("/sample-api")
//    @Retry(name = "sample-api", fallbackMethod = "hardcodedResponse")
//    @CircuitBreaker(name = "default", fallbackMethod = "hardcodedResponse")
    /*
    Rate limiter application properties: means we allow a max of 2 requests for every 10 seconds
     */
    @RateLimiter(name = "default")
    public String sampleApi() {

        logger.info("Sample API call recieved");
//        ResponseEntity<String> forEntity = new RestTemplate().getForEntity("http://localhost:8080/failure", String.class);
//
//        return forEntity.getBody();
        return "Hello world";
    }

    /*
    method accepts an Exception because the named fallbackMethod from @Retry is expecting it in the signature, otherwise
    it will not work
     */
    public String hardcodedResponse(Exception ex) {
        return "Fallback Response";
    }
}
