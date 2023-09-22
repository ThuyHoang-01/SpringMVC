package vn.edu.iuh.fit.week02_lab_hoangthitothuy_19432541.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.NativeQuery;
import vn.edu.iuh.fit.week02_lab_hoangthitothuy_19432541.models.Employee;
import vn.edu.iuh.fit.week02_lab_hoangthitothuy_19432541.models.ProductImage;

import java.util.List;

public class Product_imageDAO {

    private SessionFactory sessionFactory;


    public void setup() {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    }


    public List<Employee> listImageByProductID(int id) {
        Session session = sessionFactory.openSession();
        NativeQuery<Employee> query = session.createNativeQuery("select * from Product_image where product_id = " + id, Employee.class);
        return query.getResultList();
    }

    public void insertProductImage(ProductImage image) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(image);
        session.getTransaction().commit();
        session.close();

    }


    public void deleteProducImageById(int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.remove(session.find(ProductImage.class,id));
        session.getTransaction().commit();

    }


}
