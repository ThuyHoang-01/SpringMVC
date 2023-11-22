package vn.edu.iuh.fit.repositories;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.NativeQuery;
import vn.edu.iuh.fit.entities.Candidate;
import vn.edu.iuh.fit.entities.Company;

import java.nio.charset.CoderResult;
import java.util.List;

public class CompanyRepo {
    private SessionFactory sessionFactory;
    public  void setup(){
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    }
    public List<Company> listCompany(){
        Session session = sessionFactory.openSession();
        NativeQuery<Company> query = session.createNativeQuery("select * from company",Company.class);
        List<Company> listCompany = query.getResultList();
        return listCompany;
    }
    public void insertCompany( Company company){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.merge(company);
        session.getTransaction().commit();
        System.out.println(" Add successfully");
        session.close();
    }
    public Company findById ( int id){
        Session session = sessionFactory.openSession();
        return session.find(Company.class,id);
    }

}
