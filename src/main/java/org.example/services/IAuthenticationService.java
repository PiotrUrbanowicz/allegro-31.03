package org.example.services;

import org.example.model.User;

public interface IAuthenticationService {

    boolean authenticationUser(String login,String password);

    void registerUser(User user);
}
