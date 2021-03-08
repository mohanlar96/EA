package edu.miu.ea.assignment10.service;

import edu.miu.ea.assignment10.config.AccountEntryLogging;
import edu.miu.ea.assignment10.entity.AccountEntry;
import edu.miu.ea.assignment10.entity.Course;
import edu.miu.ea.assignment10.entity.Student;
import edu.miu.ea.assignment10.dao.EntityPersister;
import edu.miu.ea.assignment10.entity.Transcript;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

@Service
public class PersistenceService {
  @Autowired
  EntityPersister entityPersister;
  @Autowired AccountEntryLogging accountEntryLogging;
  @Autowired private EntityManager entityManager;

  public EntityManager getEntityManager() {
    return entityManager;
  }

  public void insertAll(Student student, List<Transcript> transcriptList, List<Course> courseList) {
    student.setTranscriptList(transcriptList);
    student.setCourses(courseList);
    EntityManager em = JPA_Util.getInstance().getEm();
    EntityTransaction tx = em.getTransaction();
    tx.begin();
    System.out.println("Insert student ************************************************************************************************");
    entityPersister.persistEntry(student, entityManager);

    for(Transcript transcript:transcriptList){
      entityPersister.persistEntry(transcript,entityManager);
    }

    for (Course course:courseList){
      entityPersister.persistEntry(course,entityManager);
    }
    tx.commit();
  }

  public void insertStudent(Student student) {
    EntityManager em = JPA_Util.getInstance().getEm();
    EntityTransaction tx = em.getTransaction();
    EntityPersister<Student> studentEntityPersister = new EntityPersister<>();
    tx.begin();
    System.out.println("Insert student ************************************************************************************************");
    entityPersister.persistEntry(student, entityManager);
    tx.commit();
  }
  public void addingAccountEntry(AccountEntry accountEntry){
    EntityManager em = JPA_Util.getInstance().getEm();
    EntityTransaction tx = em.getTransaction();
    tx.begin();
    System.out.println("Insert student ************************************************************************************************");
    entityPersister.persistEntry(accountEntry,entityManager);
    tx.commit();
    accountEntryLogging.logAddingAccountEntry();
  }

}
