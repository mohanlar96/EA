package edu.miu.ea.assignment9;

import edu.miu.ea.assignment9.config.ApplicationConfig;
import edu.miu.ea.assignment9.entity.Student;
import edu.miu.ea.assignment9.service.PersistenceService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
  public static void main(String[] args) {

    System.out.println("step 1 ************************************************************************************************");
    ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
    System.out.println("step 2 ************************************************************************************************");
    PersistenceService persistenceService = context.getBean("persistenceService",PersistenceService.class);
    System.out.println("step 3 ************************************************************************************************");
    Student nam = new Student("Nam","Nguyen",3.5f);
    persistenceService.insertStudent(nam);
    System.out.println("step 4 ************************************************************************************************");

  }
}
