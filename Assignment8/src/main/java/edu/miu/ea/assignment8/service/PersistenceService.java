package edu.miu.ea.assignment8.service;

import edu.miu.ea.assignment8.dao.StudentPersister;
import edu.miu.ea.assignment8.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
@Service
public class PersistenceService {
//
//  @PersistenceContext(unitName = "a8")
  @Autowired
  @Qualifier("studentPersister")
  private StudentPersister studentPersister;
  private EntityManager entityManager;

  public PersistenceService( ) {
    System.out.println("call constructor PersistenceService ************************************************************************************************");
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("Assignment8TPU");
    this.entityManager = emf.createEntityManager();
  }

  public void insertStudent(Student student){
    System.out.println("Insert student ************************************************************************************************");
    studentPersister.persistStudent(student,entityManager);
  }

}
