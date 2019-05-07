package com.resource2.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class DefaultController {

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping(value = "/reza")
    public Principal anyThing(Principal user) {
        return user;
    }
}