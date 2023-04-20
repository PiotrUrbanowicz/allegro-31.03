package org.example.database;

import org.example.model.Item;

import java.util.List;
import java.util.Optional;

public interface IItemDAO {

    List<Item> getItems();

    List<Item> getItemsByPattern(String pattern);

    Optional<Item> getItemById(int id);

    void persistItem(Item i);

    void updateItem(Item i);



}
