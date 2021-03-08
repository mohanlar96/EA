package edu.miu.ea.assignment8.dao;

import edu.miu.ea.assignment8.entity.Student;
import edu.miu.ea.assignment8.service.PersistenceService;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class StudentPersister {

  public StudentPersister(PersistenceService persistenceService) {
    System.out.println("Call StudentPersistence Constructor ************************************************************************************************");
  }

  public void persistStudent(Student student, EntityManager entityManager){
    System.out.println("Call persistStudent method ************************************************************************************************");
    EntityTransaction tx = entityManager.getTransaction();
    tx.begin();
    entityManager.persist(student);
    tx.commit();
  }
}
