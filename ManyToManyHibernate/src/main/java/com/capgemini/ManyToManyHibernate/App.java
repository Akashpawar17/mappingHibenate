package com.capgemini.ManyToManyHibernate;

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
       student.setRollno(16211);
       student.setSname("akash");
       student.setMarks(85);
       //student.setLaptop(laptop);
       student.getLaptop().add(laptop);
       laptop.getStudent().add(student);
       Configuration con =new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
       ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
        SessionFactory sf = con.buildSessionFactory(reg);
        Session session = sf.openSession();
        session.beginTransaction();
        session.save(student);
        session.save(laptop);
        //a=(Alien) session.get(Alien.class, 103);
    
        session.getTransaction().commit();
 
    }
}
