package com.one.inovation.digital.springinit.contoller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HellowControler {

    @GetMapping("/")
    public String helloMessage(){
       return "Hello";
    }
}
