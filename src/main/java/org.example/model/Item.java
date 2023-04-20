package org.example.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Item implements Saveable {
    int id;
    String name;
    String brand;
    String image;
    double price;
    int quantity;
    State state;

    public enum State {
        USER,
        ADMIN
    }
}
