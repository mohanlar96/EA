/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miu.mohan.exam2.service;


import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import miu.mohan.exam2.entities.Course;
import miu.mohan.exam2.entities.persister.CoursePersister;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author mohan
 */
public class CourseService {

  
    EntityManager em = JPA_Util.getInstance().getEm();
    private final CoursePersister coursePersister;

    @Autowired
    public CourseService(CoursePersister persister) {
        this.coursePersister = persister;
         System.out.println("calling constructor of CourseService");
    }
   
    public void create(Course course) {
        coursePersister.create(em,course);
        System.out.println("calling courseService create");

    }
     public void update(Course course) {
        coursePersister.update(em,course);
        System.out.println("calling courseService update");

    }
     public Course read(int id) {
        System.out.println("calling courseService read ");

        return coursePersister.read(em,id);

    }
     public List<Course> readAll() {
        
         System.out.println("calling courseService readAll");

        return coursePersister.readAll(em);

    }
     public void delete(Course course) {
        coursePersister.delete(em,course);
        System.out.println("calling courseService delete");

    }

}
