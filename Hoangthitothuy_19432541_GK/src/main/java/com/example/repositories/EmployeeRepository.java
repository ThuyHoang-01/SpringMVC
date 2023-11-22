package com.example.repositories;

import com.example.entities.Employee;
import jakarta.ws.rs.core.Link;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.NativeQuery;
import org.hibernate.service.Service;
import org.hibernate.service.ServiceRegistry;

import java.util.List;

public class EmployeeRepository {

     private SessionFactory sessionFactory;

     public  void  setup() {
         StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
         sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
     }
     public List<Employee> listEmployee(){
         Session session = sessionFactory.openSession();
         NativeQuery<Employee> query = session.createNativeQuery("select *from Employee",Employee.class);
         List<Employee> listEmployee = query.getResultList();

        return listEmployee;
     }
     public void insertEmployee(Employee employee){
         Session session = sessionFactory.openSession();
         session.beginTransaction();
         session.merge(employee);
         session.getTransaction().commit();
         System.out.println(" Add successfully ");
         session.close();
     }
    public Employee findEmployeeById(int id) {
        Session session = sessionFactory.openSession();
        return session.find(Employee.class,id);

    }
    public void deleteById( int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.remove(findEmployeeById(id));
        session.getTransaction().commit();

    }
}
