/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miu.mohan.exam2.entities.persister;

import java.util.List;
import miu.mohan.exam2.entities.*;
import javax.persistence.EntityManager;
import org.springframework.stereotype.Service;


/**
 *
 * @author mohan
 */
@Service
public class StudentPersister {
 
   
    public void create(EntityManager em, Student student) {
        //create 
        em.getTransaction().begin();
        em.persist(student);
        em.getTransaction().commit();
//        em.close();
        System.out.println("StudentPersister created:"+ student.getName());
    }
    
    public void update(EntityManager em, Student student) {
        //update 
        em.getTransaction().begin();
        em.persist(student);
        em.getTransaction().commit();
//        em.close();
        System.out.println("StudentPersister updated :"+ student.getName());
    }
    
    public Student read(EntityManager em, int id) {
        //read
        em.getTransaction().begin();
        Student student=em.find(Student.class, id);
        em.getTransaction().commit();
//        em.close();
        System.out.println("StudentPersister read:"+ student);
        return student;
    }
     public List<Student> readAll(EntityManager em) {
        //read
        em.getTransaction().begin();
        List<Student> listStudents=em.createQuery("Select s from Student s").getResultList();
        em.getTransaction().commit();
//        em.close();
        System.out.println("StudentPersister  read all:"+ listStudents);
        return listStudents;
    }
    public void delete(EntityManager em, Student st) {
        //delete
        em.getTransaction().begin();        
        em.remove(st);
        em.getTransaction().commit();
//        em.close();
        System.out.println("StudentPersister removed:"+ st);
    }
    
    
    
}
