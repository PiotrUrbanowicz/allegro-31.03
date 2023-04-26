package org.example.validator;

import org.example.model.User;

public class UserValidator {
    public static void validate(User user, String password2){
        //ToDo: name +error in controller
        //ToDo: surname +error in controller
        //ToDo: login +error in controller
        //ToDo: password +error in controller
        validatePasswordEquality(user.getPassword(),password2);
    }
    private static void validatePasswordEquality(String password1, String password2){
        if(!password1.equals(password2)){
            throw new RuntimeException();
        }
    }
}
