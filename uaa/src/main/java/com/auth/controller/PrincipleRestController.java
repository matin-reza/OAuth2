package com.auth.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;


@RestController
public class PrincipleRestController {

    @RequestMapping(method = RequestMethod.GET, value = "/user")
    Principal principal(Principal principal) {
        return principal;
    }
}
