package com.capgemini.ManyToManyHibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.capgemini.bean.Laptop;
import com.capgemini.bean.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       Laptop laptop = new Laptop();
       laptop.setLid(1012);
       laptop.setLname("thosibha");
       
       Student student =new Student();
       student.setSid(12121);
       student.setSname("devilers");
       student.setMarks(85);
       //student.setLaptop(laptop);
       student.getLaptop().add(laptop);
       //laptop.getStudent().add(student);
       Configuration con =new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
       ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
        SessionFactory sf = con.buildSessionFactory(reg);
        Session session = sf.openSession();
        session.beginTransaction();
        session.save(student);
        session.save(laptop);
        //a=(Alien) session.get(Alien.class, 103);
    
        session.getTransaction().commit();
        
        
        
        
        
        
        
        
        
        
        
        //Implementation with jpa specification
        /*EntityManagerFactory emf = Persistence.createEntityManagerFactory("map");
    	EntityManager em =emf.createEntityManager();
    	
    
    	
    	EntityTransaction et=em.getTransaction();
        
        et.begin();
        Laptop laptop = new Laptop();
        laptop.setLid(1012);
        laptop.setLname("thosibha");
        
        Student student =new Student();
        student.setSid(12121);
        student.setSname("devilers");
        student.setLaptop(laptop);
        student.getLaptop().add(laptop);
        //laptop.getStudent().add(student);
        em.persist(student);
        em.persist(laptop);
        
	

	et.commit();*/
        
        
        
        
        
        
        
        
        
 
    }
}
