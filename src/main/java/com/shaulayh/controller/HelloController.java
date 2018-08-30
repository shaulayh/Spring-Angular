package com.shaulayh.controller;

import com.shaulayh.Greeting;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    private long counter = 1000;
    private String template = "Gafar %s";

    @Value("${app.name}")
    private String appName;

    @Value("${app.Id}")
    private int Id;

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter, String.format(template, name));
    }

    @RequestMapping("/")
    String Hello() {
        return "index";
        //return "yellow" + appName + Id;
    }


}
