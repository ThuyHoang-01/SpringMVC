package vn.edu.iuh.fit.week02_lab_hoangthitothuy_19432541.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.NativeQuery;
import vn.edu.iuh.fit.week02_lab_hoangthitothuy_19432541.models.Product;

import java.util.List;

public class ProductDAO {

    private SessionFactory sessionFactory;


    public void setup() {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    }


    public List<Product> listProduct() {
        Session session = sessionFactory.openSession();
        NativeQuery<Product> query = session.createNativeQuery("select * from Product", Product.class);
        return query.getResultList();
    }

    public void insertProduct(Product product) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(product);
        session.getTransaction().commit();
        session.close();

    }

    public Product findProductById(int id) {
        Session session = sessionFactory.openSession();
        return session.find(Product.class, id);

    }

    public void deleteProductById(int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.remove(findProductById(id));
        session.getTransaction().commit();

    }


}
