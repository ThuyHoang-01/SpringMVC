package com.example.repositories;

import com.example.entities.Manager;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.NativeQuery;

import java.util.List;

public class ManagerRepository {
    private SessionFactory sessionFactory;


    public void setup() {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    }
    public List<Manager> listManager() {
        Session session = sessionFactory.openSession();
        NativeQuery<Manager> query = session.createNativeQuery("select * from manager", Manager.class);
        List<Manager> listManager = query.getResultList();

        return listManager;
    }

    public void insertManager(Manager manager) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.merge(manager);
        session.getTransaction().commit();
        System.out.println("Add successfully");
        session.close();

    }
    public Manager findById( int id) {
        Session session = sessionFactory.openSession();
        return session.find(Manager.class,id);

    }
    public void deleteById( int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Manager manager = new Manager();
        manager.setMa_id(id);
        session.remove(manager);
        session.getTransaction().commit();

    }
}
