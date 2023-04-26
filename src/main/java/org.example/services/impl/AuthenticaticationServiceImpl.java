package org.example.services.impl;

import org.example.database.IUserDAO;
import org.example.model.User;
import org.example.services.IAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticaticationServiceImpl implements IAuthenticationService {

    @Autowired
    IUserDAO userDAO;

    @Override
    public boolean authenticationUser(String login,String password) {
        Optional<User> user=userDAO.getUserById(1);
        System.out.println(user.isPresent());

        if(user.isPresent() && user.get().getPassword().equals(password)){
            return true;
        }
        return false;
    }

    @Override
    public void registerUser(User user) {
        user.setRole(User.Role.USER);
        this.userDAO.persistUser(user);
    }
}
