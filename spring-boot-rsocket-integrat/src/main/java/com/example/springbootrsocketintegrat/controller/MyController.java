package com.example.springbootrsocketintegrat.controller;


import com.example.springbootrsocketintegrat.bean.User;
import org.springframework.messaging.rsocket.RSocketRequester;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @Author qrn
 * @Title
 * @Date 2021/6/16 16:15
 * @time 16:15
 */
@RestController
public class MyController {

    private final RSocketRequester rsocketRequester;

    public MyController(RSocketRequester.Builder rsocketRequesterBuilder) {
        this.rsocketRequester = rsocketRequesterBuilder.tcp("localhost", 9898);
    }

    @RequestMapping("/")
    public Mono<User> someRSocketCall(String name) {
        return this.rsocketRequester.route("user").data(name).retrieveMono(User.class);
    }


}
