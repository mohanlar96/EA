/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.miu.mohan.assignment9_1.services;

import edu.miu.mohan.assignment9_1.entities.Student;
import edu.miu.mohan.assignment9_1.persisters.StudentPersister;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author mohan
 */
@Service("studentService")
public class StudentServiceImpl implements StudentService {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("StudentPU");
    EntityManager em = emf.createEntityManager();

    @Autowired
    private StudentPersister studentPersister;

 
    @Override
    public void save(Student student) {
        studentPersister.Save(em,student);
        System.out.println("calling savestudent of StudentServiceImpl");

    }

}
