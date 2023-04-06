package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    int id;
    String name;
    String surname;
    String login;
    String password;
    Role role;

    public enum Role {
        USER,
        ADMIN
    }
}
