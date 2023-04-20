package org.example.database.hibernate;

import org.example.Exceptions.UserLoginExistException;
import org.example.database.IItemDAO;
import org.example.model.Item;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Optional;

public class ItemDAOImpl extends EntityManager implements IItemDAO {

    public ItemDAOImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public List<Item> getItems() {
        return null;
    }

    @Override
    public List<Item> getItemsByPattern(String pattern) {
        return null;
    }

    @Override
    public Optional<Item> getItemById(int id) {
        return Optional.empty();
    }

    @Override
    public void persistItem(Item item) {
        try {
            super.persist(item);
        } catch (UserLoginExistException e) {
            System.out.println("błąd w persistItem");
        }
    }

    @Override
    public void updateItem(Item item) {
        super.update(item);
    }
}
