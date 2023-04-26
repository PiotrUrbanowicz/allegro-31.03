package org.example.database.hibernate;

import org.example.Exceptions.UserLoginExistException;
import org.example.database.IItemDAO;
import org.example.model.Item;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class ItemDAOImpl implements IItemDAO {

    @Autowired
    SessionFactory sessionFactory;

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
        Session session=sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.persist(item);
            session.getTransaction().commit();
        }catch (Exception e){
            session.getTransaction().rollback();
        }finally{
            session.close();
        }
        }

    @Override
    public void updateItem(Item item) {

    }
}
