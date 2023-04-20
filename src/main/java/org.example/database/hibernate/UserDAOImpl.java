package org.example.database.hibernate;

import org.example.Exceptions.UserLoginExistException;
import org.example.database.IUserDAO;
import org.example.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class UserDAOImpl extends EntityManager implements IUserDAO {

    public UserDAOImpl(@Autowired SessionFactory sessionFactory){
        super(sessionFactory);
    }
    @Override
    public Optional<User> getUserById(int id) {
      Session session=sessionFactory.openSession();
        Query<User> query=session.createQuery("FROM org.example.model.User WHERE id=:id");
        query.setParameter("id",id);
        Optional<User> result=Optional.empty();
        try {
            result=Optional.of(query.getSingleResult());
        }catch (Exception e){}
        session.close();
        return result;
    }

    @Override
    public Optional<User> getUserByLogin(String login) {
        Session session=sessionFactory.openSession();
        Query<User> query=session.createQuery("From org.example.model.User WHERE login=:login");
        query.setParameter("login",login);
        Optional<User> result=Optional.empty();
        try {
            result=Optional.of(query.getSingleResult());
        }catch (Exception e){}
        session.close();
        return result;
    }
    
    @Override
    public void persistUser(User user) {
        try {
            super.persist(user);
        } catch (UserLoginExistException e) {
            System.out.println("login już istnieje");
            //TODO:
        }
    }
}
