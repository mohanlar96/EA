/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.miu.mohan.assignment8_2.services;

import edu.miu.mohan.assignment8_2.entities.Student;
import edu.miu.mohan.assignment8_2.persisters.StudentPersister;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author mohan
 */
public class StudentServiceImpl implements StudentService {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("StudentPU");
    EntityManager em = emf.createEntityManager();
    private final StudentPersister studentPersister;

    @Autowired
    public StudentServiceImpl(StudentPersister persister) {
        this.studentPersister = persister;
         System.out.println("calling constructor of StudentServiceImpl");
    }
   
    @Override
    public void save(Student student) {
        studentPersister.Save(em,student);
        System.out.println("calling savestudent of StudentServiceImpl");

    }

}
