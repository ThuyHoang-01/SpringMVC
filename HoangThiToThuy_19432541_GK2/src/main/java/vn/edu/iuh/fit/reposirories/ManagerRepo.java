package vn.edu.iuh.fit.reposirories;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.NativeQuery;
import vn.edu.iuh.fit.entities.Employee;
import vn.edu.iuh.fit.entities.Manager;

import java.util.List;

public class ManagerRepo {
    private SessionFactory sessionFactory;
    public void setup(){
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    }
    public List<Manager> listManager(){
        Session session = sessionFactory.openSession();
        NativeQuery<Manager> query = session.createNativeQuery("select * from manager",Manager.class);
        List<Manager> listManager = query.getResultList();

        return listManager;
    }
    public void insertManager(Manager manager){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.merge(manager);
        session.getTransaction().commit();
        System.out.println("Add Manager Successfully");
        session.close();
    }
    public Manager findManagerById( int id){
        Session session = sessionFactory.openSession();
        return session.find(Manager.class,id);
    }
}
