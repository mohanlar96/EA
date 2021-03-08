package edu.miu.ea.assignment9.service;

import edu.miu.ea.assignment9.entity.Student;
import edu.miu.ea.assignment9.dao.StudentPersister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Service
public class PersistenceService {

  @Autowired
  private StudentPersister studentPersister;
  @Autowired
  private EntityManager entityManager;

  public EntityManager getEntityManager() {
    return entityManager;
  }

  public void insertStudent(Student student) {
    System.out.println("Insert student ************************************************************************************************");
    studentPersister.persistStudent(student, entityManager);
  }
}
