package edu.miu.ea.assignment10.config;

import org.springframework.scheduling.annotation.Scheduled;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class ScheduleTimer {
  @Scheduled(fixedRate = 5000, initialDelay =  1000)
  public void timer(){
    Date date = Calendar.getInstance().getTime();
    DateFormat timeFormatter = DateFormat.getTimeInstance(DateFormat.DEFAULT);
    String currentTime = timeFormatter.format(date);
    System.out.println("Current time is: "+currentTime);
  }
}
