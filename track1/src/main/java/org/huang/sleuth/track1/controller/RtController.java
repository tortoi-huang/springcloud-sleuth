package org.huang.sleuth.track1.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.client.loadbalancer.reactive.ReactorLoadBalancerExchangeFilterFunction;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
public class RtController {

    private final static Logger log = LoggerFactory.getLogger(RtController.class);

    private final ReactorLoadBalancerExchangeFilterFunction lbFunction;

    public RtController(ReactorLoadBalancerExchangeFilterFunction lbFunction) {
        this.lbFunction = lbFunction;
    }

    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    public Mono<String> hi(@RequestParam("name") String name) {
        log.info(" = = = <call trace-1 to 2> == = ");
        WebClient.RequestHeadersSpec<?> uri = WebClient.builder()
                .filter(lbFunction)
                .build().get()
                .uri(
                        "http://trace-2/hi?name=" + name //这里要用服务注册名称，不要用主机名
                        /*ub -> ub.scheme("http")
                                .host("trace-2")
                                //.port(9102).path("/hi")
                                .queryParam("name", name).build()*/
                );
        return uri.retrieve().bodyToMono(String.class);
    }
}
