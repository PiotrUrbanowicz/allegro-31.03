package org.example.controllers;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CommonController {


    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String main() {
        return "main";
    }

    @RequestMapping(path = "/main", method = RequestMethod.GET)
    public String main2() {
        return "redirect:/";
    }

    @RequestMapping(path = "/contact", method = RequestMethod.GET)
    public String contact() {
        return "contact";
    }

}
