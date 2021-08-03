package org.huang.sleuth.track1.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
public class LbController {

    private final static Logger log = LoggerFactory.getLogger(LbController.class);

    private final WebClient.Builder loadBalancedWebClientBuilder;
    public LbController(WebClient.Builder loadBalancedWebClientBuilder) {
        this.loadBalancedWebClientBuilder = loadBalancedWebClientBuilder;
    }

    @RequestMapping("/trace-2")
    public Mono<String> trace2() {
        return loadBalancedWebClientBuilder.build().get().uri("http://localhost:9102/trace-2")
                .retrieve().bodyToMono(String.class);
    }

    @RequestMapping("/hi2")
    public Mono<String> hi2(@RequestParam(value = "name", defaultValue = "Mary") String name) {
        log.info(" = = = <call trace-1 hi2> == = ");
        return loadBalancedWebClientBuilder.build().get().uri("http://localhost:9102/hi?name=" + name)
                .retrieve().bodyToMono(String.class);
    }
}
