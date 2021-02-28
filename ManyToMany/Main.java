/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.miu.second;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author black
 */
public class Main {
    public static void main(String[] args ){
        
        System.out.println("started");
        Student stu = new Student();
        stu.setName("jack");
        stu.setGpa(3.75);
        List<Student> student = new ArrayList();
        student.add(stu);
        
        
         
        List<Book> books = new ArrayList();
        books.add(new Book("book of eli",402,stu));
        books.add(new Book("mirror",208,stu));
        
        List<Course> courses= new ArrayList();
        courses.add(new Course("Biology",4, student));
        courses.add(new Course("MicroLink",3, student));
        
        stu.setBooks(books);
        stu.setCourses(courses);
        
        
        EntityManagerFactory emf =Persistence.createEntityManagerFactory("TestDBPU");
        EntityManager em =emf.createEntityManager();
        EntityTransaction tx= em.getTransaction();
        tx.begin();
        
        em.persist(stu);

//         Student kel=em.find(Student.class, 151l);
//         em.remove(kel);
//         System.out.println("hello"+kel);
       
        tx.commit();
        em.close();
//       tx.close();
        
        
        
                  
        
    }
    
}
