package com.gateway.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultController {

    @GetMapping
    public String anyThing() {
        return "this is a secure call inside gateway without propagating into resource server ";
    }
}
