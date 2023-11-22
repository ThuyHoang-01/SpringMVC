package vn.edu.iuh.fit.repositories;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.registry.internal.StandardServiceRegistryImpl;
import org.hibernate.query.NativeQuery;
import vn.edu.iuh.fit.entities.Candidate;

import java.util.List;

public class CandidateRepo {
    private SessionFactory sessionFactory;
    public  void setup(){
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    }
    public List<Candidate> listCandidate(){
        Session session = sessionFactory.openSession();
        NativeQuery<Candidate> query = session.createNativeQuery("select * from candidate",Candidate.class);
        List<Candidate> listCandidate = query.getResultList();
        return listCandidate;
    }
    public void insertCandidate ( Candidate candidate){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.merge(candidate);
        session.getTransaction().commit();
        System.out.println(" Add successfully");
        session.close();
    }
    public Candidate findCandidateById ( int id){
        Session session = sessionFactory.openSession();
        return session.find(Candidate.class,id);
    }
}
