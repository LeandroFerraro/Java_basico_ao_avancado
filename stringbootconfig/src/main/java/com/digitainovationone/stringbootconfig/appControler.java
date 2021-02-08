package com.digitainovationone.stringbootconfig;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class appControler {

    @Value("${app.message}")
    private String appMessage;

    @GetMapping("/")
    public String appMessage(){
        return appMessage;
    }

}
