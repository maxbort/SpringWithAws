package com.springboot.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //컨트롤러를 JSON을 반환하는 컨트롤러로 만들어줌
public class HelloController {

    @GetMapping("/hello") //Get 요청을 받을 수 잇는 API를 만들어준다.
    public String hello(){
        return "hello";
    }
}
