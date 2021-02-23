/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mid.cs544;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author mohan
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Starting .....");
        
        Student jack=new Student();
        jack.setName("Mohan");
        jack.setGpa(2.2f);
        
        EntityManagerFactory emf=Persistence.createEntityManagerFactory("testDB1PU");
        EntityManager em= emf.createEntityManager();
        EntityTransaction tx=em.getTransaction();
        
        tx.begin();
        em.persist(jack);  
        tx.commit();
        em.close();
        emf.close();
        System.out.println("ENDing ...... ");
        
    }
    
}
