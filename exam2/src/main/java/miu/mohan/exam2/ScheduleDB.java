package miu.mohan.exam2;

import org.springframework.scheduling.annotation.Scheduled;

import miu.mohan.exam2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ScheduleDB {
    
    @Autowired
    private StudentService stdService;

  @Scheduled(fixedRate = 3000, initialDelay =  1000)
  public void timer(){


    System.out.println("Number of student in DB: "+stdService.readAll().size());
  }
}
