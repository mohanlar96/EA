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
import miu.mohan.exam2.entities.Student;
import miu.mohan.exam2.entities.persister.StudentPersister;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author mohan
 */
public class StudentService {

  
    EntityManager em = JPA_Util.getInstance().getEm();
    private final StudentPersister studentPersister;

    @Autowired
    public StudentService(StudentPersister persister) {
        this.studentPersister = persister;
         System.out.println("calling constructor of StudentService");
    }
   
    public void create(Student student) {
        studentPersister.create(em,student);
        System.out.println("calling stdService create");

    }
     public void update(Student student) {
        studentPersister.update(em,student);
        System.out.println("calling stdService update");

    }
     public Student read(int id) {
        System.out.println("calling stdService read ");

        return studentPersister.read(em,id);

    }
     public List<Student> readAll() {
        
         System.out.println("calling stdService readAll");

        return studentPersister.readAll(em);

    }
     public void delete(Student st) {
        studentPersister.delete(em,st);
        System.out.println("calling stdService delete");

    }

}
