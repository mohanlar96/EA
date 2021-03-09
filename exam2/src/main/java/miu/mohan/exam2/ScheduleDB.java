package miu.mohan.exam2;

import org.springframework.scheduling.annotation.Scheduled;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import miu.mohan.exam2.service.StudentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ScheduleDB {
  @Scheduled(fixedRate = 3000, initialDelay =  1000)
  public void timer(){
    ApplicationContext context = new ClassPathXmlApplicationContext("springconfig.xml");

    StudentService stdService = context.getBean("studentService",StudentService.class);

    System.out.println("Number of student in DB: "+stdService.readAll().size());
  }
}
