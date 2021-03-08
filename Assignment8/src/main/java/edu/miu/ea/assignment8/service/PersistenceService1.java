package edu.miu.ea.assignment8.service;

import edu.miu.ea.assignment8.dao.StudentPersister;
import edu.miu.ea.assignment8.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Service
public class PersistenceService1 {

  private StudentPersister studentPersister;
  private EntityManager entityManager;
  @Autowired
  public PersistenceService1(StudentPersister studentPersister ) {
    System.out.println("call constructor PersistenceService ************************************************************************************************");
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("Assignment8TPU");
    this.entityManager = emf.createEntityManager();
    this.studentPersister = studentPersister;
  }

  public void insertStudent(Student student){
    System.out.println("Insert student ************************************************************************************************");
    studentPersister.persistStudent(student,entityManager);
  }

}
