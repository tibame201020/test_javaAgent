package com.custom.beAgentApp;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api")
public class RestApi {
    @RequestMapping("/test")
    public Flux<String> testApi() {
        return Flux.just("in ", "the ", "controller");
    }
}
