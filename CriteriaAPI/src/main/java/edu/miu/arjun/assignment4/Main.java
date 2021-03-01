/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.miu.mohan.assignment4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author mohan
 */
public class Main {

    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("CPU");
    static EntityManager em = emf.createEntityManager();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        em.getTransaction().begin();
        try {
            //Address
             Address iowa = new Address();
             iowa.setCity("iowa");
             iowa.setStreet("1000 N 4th");
             iowa.setZip("9987");
             
             Address ny = new Address();
             ny.setCity("newyork");
             ny.setStreet("Denise drive");
             ny.setZip("6655");
             
            em.persist(iowa);
            em.persist(ny);
             
           

            //author
            Author author1 = new Author();
            author1.setName("author1");
            author1.setAddress(iowa);
            em.persist(author1);

            //publisher
            Publisher oxfordPress = new Publisher();
            oxfordPress.setName("oxford");
            oxfordPress.setNumOfEmp(200);

            Publisher londonPress = new Publisher();
            londonPress.setName("londonPress");
            londonPress.setNumOfEmp(100);
            em.persist(oxfordPress);
            em.persist(londonPress);
            //books
            Book ea = new Book();
            ea.setAuthor(author1);
            ea.setPageCount(200);
            ea.setPublisher(oxfordPress);
            ea.setTitle("EA");
            

            Book wap = new Book();
            wap.setAuthor(author1);
            wap.setPageCount(200);
            wap.setPublisher(londonPress);
            wap.setTitle("wap");

            Book mpp = new Book();
            mpp.setAuthor(author1);
            mpp.setPageCount(99);
            mpp.setPublisher(oxfordPress);
            mpp.setTitle("mpp");
            em.persist(ea);
            em.persist(wap);
            em.persist(mpp);

            
             //student
            Student jack = new Student();
            jack.setName("jack");
            jack.setGpa(4.0f);
            jack.setBooks(new ArrayList<>( Arrays.asList(ea,wap)));
            
            Student jill = new Student();
            jill.setName("jill");
            jill.setGpa(2.5f);
            jill.setBooks(new ArrayList<>( Arrays.asList(ea,mpp)));
            Student jim = new Student();
            jim.setName("jim");
            jim.setGpa(4.0f);
            jim.setBooks(new ArrayList<>( Arrays.asList(wap,mpp)));
            em.persist(jack);
            em.persist(jill);
            em.persist(jim);
            
            
            Student student = em.find(Student.class, jim.getId());
            student.setName("jim1");
            em.getTransaction().commit();
            
           List<Book> booksForStudentGpaGTOrEq3 = em.createNamedQuery("Student.booksForStudentGpaGTOrEq3").getResultList();
           
          System.out.println(booksForStudentGpaGTOrEq3.toString());
                
          List<Book> booksForStudentGpaGTOrEq3AndPagesGT100 = em.createNamedQuery("Student.booksForStudentGpaGTOrEq3AndPagesGT100").getResultList();
           
          System.out.println(booksForStudentGpaGTOrEq3AndPagesGT100.toString());
          
          //criteria query
          //Write a criteria query to find the book with pages more than or equal to 120
          //pages and belonging to students with gpa >= 3.0 and written by an Author living in Iowa,
          //and the book is published by a publisher with more than 100 employees.
          
           
            CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
            CriteriaQuery<Book> criteriaQuery = criteriaBuilder.createQuery(Book.class);
            
            
            Root<Student> studentRoot = criteriaQuery.from(Student.class);
            Join<Student,Book> bookJoin = studentRoot.join("books");
            Join<Book,Publisher> publisherJoin = bookJoin.join("publisher");
            Join<Book,Author> authorJoin = bookJoin.join("author");
            Join<Author,Address> addressJoin = authorJoin.join("address");
            
            
            Predicate gpaPredicate = criteriaBuilder.greaterThanOrEqualTo(studentRoot.get(Student_.gpa),3.0);
            Predicate bookPredicate = criteriaBuilder.greaterThanOrEqualTo(bookJoin.get(Book_.pageCount),120);
            Predicate publisherPredicate = criteriaBuilder.greaterThan(publisherJoin.get(Publisher_.numOfEmp),100);
            Predicate addressPredicate = criteriaBuilder.equal(addressJoin.get(Address_.city),"Iowa");
            Predicate andPredicate = criteriaBuilder.and(gpaPredicate,bookPredicate,publisherPredicate,addressPredicate);
           
            criteriaQuery.select(bookJoin);
            criteriaQuery.where(andPredicate);
            
            TypedQuery<Book> bookAll = em.createQuery(criteriaQuery);
            List<Book> bookList = bookAll.getResultList();
            System.out.println("*************************************************************************");
            for(Book book:bookList){
              System.out.println(book.toString());
            }
            System.out.println("*************************************************************************");
            em.getTransaction().commit();
            em.close();
            emf.close();
            System.out.println("End");
            
            
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
            em.close();
        }

    }

}
