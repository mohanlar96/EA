package edu.miu.ea.assignment9.config;

import edu.miu.ea.assignment9.advice.TraceAdvice;
import edu.miu.ea.assignment9.dao.StudentPersister;
import edu.miu.ea.assignment9.service.PersistenceService;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Lazy;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Configuration
@EnableAspectJAutoProxy
public class ApplicationConfig {

@Bean
@Lazy(value = true)
public PersistenceService persistenceService(){
    PersistenceService persistenceService = new PersistenceService();
    return persistenceService;
  }
@Bean
@Lazy(value = true)
public StudentPersister studentPersister(){
    StudentPersister studentPersister = new StudentPersister();
    return studentPersister;
}

@Bean
public EntityManager entityManager(){
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Assignment9TPU");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    return entityManager;
}

@Bean
public TraceAdvice traceAdvice(){
    TraceAdvice traceAdvice = new TraceAdvice();
    return traceAdvice;
}
}
