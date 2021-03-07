/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package learning.inheritancetypes;

import inheritic.single.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author Mohan
 */
public class Main {
    
    public static void main(String[] args) {
        
        System.out.println("Starting ....");          
        
        EntityManagerFactory  emf=Persistence.createEntityManagerFactory("IPU");
        EntityManager em=emf.createEntityManager();
        EntityTransaction tx=em.getTransaction();
        
        tx.begin();
        
        
       
        
        Student s= new Student();
        s.setCourses("MPP");
        s.setGpa(2.0F);
        s.setName("mohan BRO");
        s.setAge(21);
        
        
        
       
        em.persist(s);  
        
        Student student= em.find(Student.class,1L);
        System.out.println("student  " + student);

       
        
        
        
        
        
            
        tx.commit();
        em.close();
        emf.close();        
        
        System.out.println("Ending.....");
        
        
        
    }
    
}
