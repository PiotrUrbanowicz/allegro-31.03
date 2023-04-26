package org.example.database;

import org.example.Exceptions.UserLoginExistException;
import org.example.model.User;

import java.util.Optional;

public interface IUserDAO {

    Optional<User> getUserById(int id);

    Optional<User> getUserByLogin(String login);

    void persistUser(User user);
}
