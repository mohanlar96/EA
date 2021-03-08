package edu.miu.ea.assignment9.dao;
import edu.miu.ea.assignment9.entity.Student;
import edu.miu.ea.assignment9.service.PersistenceService;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

@Repository
public class StudentPersister {

  public StudentPersister() {
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
