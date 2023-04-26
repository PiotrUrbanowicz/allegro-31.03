package org.example.database.hibernate;

import jakarta.persistence.NoResultException;
import org.example.database.IUserDAO;
import org.example.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserDAOImpl implements IUserDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Optional<User> getUserById(int id) {
        return Optional.empty();
    }

    @Override
    public Optional<User> getUserByLogin(String login) {
        Session session = this.sessionFactory.openSession();
        Query<User> query = session.createQuery(
                "FROM pl.camp.it.book.store.model.User WHERE login = :login",
                User.class);
        query.setParameter("login", login);
        Optional<User> result = Optional.empty();
        try {
            result = Optional.of(query.getSingleResult());
        } catch (NoResultException e){}
        session.close();
        return result;
    }

    @Override
    public void persistUser(User user) {
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();
        System.out.println(user);
        try {
            session.persist(user);
            session.getTransaction().commit();
            session.close();
        }catch (Exception e){
            System.out.println(e);
            System.out.println();
            System.out.println(e.getMessage());
        }

    }
}
