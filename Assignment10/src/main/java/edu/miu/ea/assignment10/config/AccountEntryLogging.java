package edu.miu.ea.assignment10.config;

import org.springframework.scheduling.annotation.Async;

public class AccountEntryLogging {
  @Async
  public void logAddingAccountEntry(){
    try {
      Thread.sleep(15000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("******************************************** Finished adding Account Entry ********************************************");
  }
}
