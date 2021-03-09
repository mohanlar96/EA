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
public class CoursePersister {
 
   
    public void create(EntityManager em, Course course) {
        //create 
        em.getTransaction().begin();
        em.persist(course);
        em.getTransaction().commit();
//        em.close();
        System.out.println("CoursePersister created:"+ course.getCapacity());
    }
    
    public void update(EntityManager em, Course course) {
        //update 
        em.getTransaction().begin();
        em.persist(course);
        em.getTransaction().commit();
//        em.close();
        System.out.println("CoursePersister updated :"+ course.getCapacity());
    }
    
    public Course read(EntityManager em, int id) {
        //read
        em.getTransaction().begin();
        Course course=em.find(Course.class, id);
        em.getTransaction().commit();
//        em.close();
        System.out.println("CoursePersister read:"+ course);
        return course;
    }
     public List<Course> readAll(EntityManager em) {
        //read
        em.getTransaction().begin();
        List<Course> listCourses=em.createQuery("Select s from Course s").getResultList();
        em.getTransaction().commit();
//        em.close();
        System.out.println("CoursePersister readAll:"+ listCourses);
        return listCourses;
    }
    public void delete(EntityManager em, Course course) {
        //delete
        em.getTransaction().begin();        
        em.remove(course);
        em.getTransaction().commit();
//        em.close();
        System.out.println("CoursePersister removed:"+ course);
    }
    
    
    
}
