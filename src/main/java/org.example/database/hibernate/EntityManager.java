package org.example.database.hibernate;


import org.example.Exceptions.UserLoginExistException;
import org.example.model.Saveable;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class EntityManager {
    public final SessionFactory sessionFactory;

    public EntityManager(@Autowired SessionFactory sessionFactory){
        this.sessionFactory=sessionFactory;
    }

    void persist(Saveable o) throws UserLoginExistException {//czemu nie ma rollback
        Session session= sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.persist(o);
            session.getTransaction().commit();
            session.close();
        }catch (Exception e){
            throw new UserLoginExistException();
        }
        }

        void update(Saveable o){
        Session session=sessionFactory.openSession();
        try{
            session.beginTransaction();
            session.merge(o);
            session.getTransaction().commit();
        }catch (Exception e){
            session.getTransaction().rollback();
        }finally {
            session.close();
        }
        }



}
