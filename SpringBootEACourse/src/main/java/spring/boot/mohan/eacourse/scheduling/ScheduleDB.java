package spring.boot.mohan.eacourse.scheduling;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import spring.boot.mohan.eacourse.reposisty.StudentRepository;


@Component
public class ScheduleDB {
  @Autowired
  private StudentRepository stdRepo;
  @Scheduled(fixedRate = 3000, initialDelay =  1000)
  public void timer(){
    System.out.println("Number of student in DB: "+ stdRepo.count());
  }
}
