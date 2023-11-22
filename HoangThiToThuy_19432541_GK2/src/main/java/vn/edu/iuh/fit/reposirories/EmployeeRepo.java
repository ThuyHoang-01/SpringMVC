package vn.edu.iuh.fit.reposirories;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.registry.internal.StandardServiceRegistryImpl;
import org.hibernate.query.NativeQuery;
import vn.edu.iuh.fit.entities.Employee;

import java.util.List;

public class EmployeeRepo {
    private SessionFactory sessionFactory;
    public void setup(){
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    }
    public List<Employee> listEmployee(){
        Session session = sessionFactory.openSession();
        NativeQuery<Employee> query = session.createNativeQuery("select * from Employee",Employee.class);
        List<Employee> listEmployee = query.getResultList();
        return listEmployee;
    }
    public void insertEmployee(Employee employee){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.merge(employee);
        session.getTransaction().commit();
        System.out.println("Add Employee Successfully");
        session.close();
    }
    public Employee findEmployeeById( int id){
        Session session = sessionFactory.openSession();
        return session.find(Employee.class,id);
    }
}
