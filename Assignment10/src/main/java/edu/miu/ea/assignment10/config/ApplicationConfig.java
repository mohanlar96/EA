package edu.miu.ea.assignment10.config;

import edu.miu.ea.assignment10.advice.TraceAdvice;
import edu.miu.ea.assignment10.service.PersistenceService;
import edu.miu.ea.assignment10.dao.EntityPersister;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Configuration
@EnableAspectJAutoProxy
@EnableScheduling
//@Async
public class ApplicationConfig {

@Bean
@Lazy(value = true)
  public PersistenceService persistenceService(){
  PersistenceService persistenceService = new PersistenceService();
  return persistenceService;
  }
@Bean
  @Lazy(value = true)
  public EntityPersister entityPersister(){
  EntityPersister entityPersister = new EntityPersister<>();
  return entityPersister;
}

@Bean
@Async
public AccountEntryLogging accountEntryLogging(){
  AccountEntryLogging accountEntryLogging = new AccountEntryLogging();
  return accountEntryLogging;
}
@Bean
  public EntityManager entityManager(){
  EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Assignment10TPU");
  EntityManager entityManager = entityManagerFactory.createEntityManager();
  return entityManager;
}

@Bean
  public TraceAdvice traceAdvice(){
  TraceAdvice traceAdvice = new TraceAdvice();
  return traceAdvice;
}
@Bean
  public ScheduleTimer scheduleTimer(){
  ScheduleTimer scheduleTimer = new ScheduleTimer();
  return scheduleTimer;
}
}
