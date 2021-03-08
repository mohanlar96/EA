package edu.miu.ea.assignment8;

import edu.miu.ea.assignment8.entity.Student;
import edu.miu.ea.assignment8.service.PersistenceService;
import edu.miu.ea.assignment8.service.PersistenceService1;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application1 {
  public static void main(String[] args) {

    System.out.println("step 1 ************************************************************************************************");
    ApplicationContext context = new ClassPathXmlApplicationContext("springConfig.xml");
    System.out.println("step 2 ************************************************************************************************");
    PersistenceService1 persistenceService = context.getBean("persistenceService1",PersistenceService1.class);
    System.out.println("step 3 ************************************************************************************************");
    Student nam = new Student("Bao",3.5f);
    persistenceService.insertStudent(nam);
    System.out.println("step 4 ************************************************************************************************");

  }
}
