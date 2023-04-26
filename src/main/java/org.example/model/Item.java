package org.example.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="titem")
public class Item implements Saveable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String name;
    private String brand;
    private String image;
    private double price;
    private int quantity;
    @Enumerated(EnumType.STRING)
    private State state;

    public enum State {
        USER,
        ADMIN
    }
}
