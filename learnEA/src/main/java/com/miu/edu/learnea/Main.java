package com.miu.edu.learnea;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import com.miu.edu.learnea.model.*;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
/**
 *
 * @author Mohan
 */
public class Main {
    
    
    public static void main(String[] args) {
        
        System.out.println("Starting ....");          
        
        EntityManagerFactory emf=Persistence.createEntityManagerFactory("LPU");
        EntityManager em=emf.createEntityManager();
        EntityTransaction tx=em.getTransaction();
        
        tx.begin();
        
         //--- ONE TO ONE START 
         
//        Address a =new Address("Fairfield");
//        Employee e= new Employee("mohan",a);
//        em.persist(e);

        //--- ONE TO ONE END
        
        List<Employee> empList= new ArrayList<Employee>();
//       
        empList.add(new Employee("Mohan",new Address("Fairfield")));
        empList.add(new Employee("mohan",new Address("Fairfield")));
        empList.add(new Employee("Rajeev",new Address("Fairfield")));        
//        
//        
        Department d=new Department("English",empList);
        em.persist(d);

//        USING JPQL

//           Query q=em.createQuery("SELECT d FROM Department d ");
//           System.out.println("department list are " +q.getResultList());

//       END USING JPSQ 

          List<Bug> bugList= new ArrayList<Bug>();
          
          

        

        tx.commit();
        
        Department dep=em.find(Department.class, 1l);
        System.out.println("department list "+dep);
        em.close();
        emf.close();  
        
        
        
        System.out.println("Ending.....");
        
        
    }
    
}
