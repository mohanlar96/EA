/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.miu.mohan.assignment9_2.persisters;

import edu.miu.mohan.assignment9_2.entities.Student;
import javax.persistence.EntityManager;
import org.springframework.stereotype.Service;


/**
 *
 * @author mohan
 */
@Service
public class StudentPersisterImpl implements StudentPersister{
 
   
    @Override
    public void Save(EntityManager em, Student student) {
        em.getTransaction().begin();
        em.persist(student);
        em.getTransaction().commit();
        em.close();
        System.out.println("Student saved:"+ student.getFirstName());
    }
    
}
