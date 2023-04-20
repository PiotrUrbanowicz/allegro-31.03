package org.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AuthenticationController {

    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public String login() {
        return "login-form";
    }



    @RequestMapping(path = "/user/add", method = RequestMethod.GET)
    public String user() {
        return "user-form";
    }

}
