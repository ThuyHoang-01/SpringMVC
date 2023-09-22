package vn.edu.iuh.fit.week02_lab_hoangthitothuy_19432541.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.NativeQuery;
import vn.edu.iuh.fit.week02_lab_hoangthitothuy_19432541.models.Employee;

import java.util.List;

public class EmployeeDAO {
    private SessionFactory sessionFactory;


    public void setup() {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    }


    public List<Employee> listEmployee() {
        Session session = sessionFactory.openSession();
        NativeQuery<Employee> query = session.createNativeQuery("select * from Employee", Employee.class);
        List<Employee> listEmployee = query.getResultList();

        return listEmployee;
    }

    public void insertEmployee(Employee employee) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(employee);
        session.getTransaction().commit();
        System.out.println("add successfull");
        session.close();

    }
    public Employee findById( int id) {
        Session session = sessionFactory.openSession();
        return session.find(Employee.class,id);

    }

    public void deleteById( int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.remove(findById(id));
        session.getTransaction().commit();

    }


}
