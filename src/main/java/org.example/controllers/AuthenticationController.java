package org.example.controllers;

import org.example.model.User;
import org.example.services.IAuthenticationService;
import org.example.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthenticationController {

    @Autowired
    IAuthenticationService authenticationService;


    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public String login() {
        return "login-form";
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(@RequestParam String login,@RequestParam String password) {//--obejrzyj jak to zrobił
       if(this.authenticationService.authenticationUser(login,password)){
           return "redirect:/";
       }
        return "login-form";

    }

    @RequestMapping(path = "/register", method = RequestMethod.GET)
    public String saveUser(Model model) {
        model.addAttribute("user",new User());
        return "user-form";
    }

    @RequestMapping(path = "/register", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute User user, @RequestParam String password2) {

        try {
            //UserValidator.validate(user, password2);
            this.authenticationService.registerUser(user);
        }catch (Exception e){
        //ToDO:coś
            System.out.println("controller");
            return "user-form";
        }
        return "login-form";
    }

}
