package exam3.exam.scheduling;

import exam3.exam.entities.Receipt;
import exam3.exam.service.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
public class receiptSchedule {
  @Autowired
  private ReceiptService recService;
  
  @Autowired
    private JmsTemplate jmsTemplate; 
  
  @Scheduled(fixedRate = 3000)
  public void timer(){
      
      Receipt rec=recService.getReceipt(4l);
      Receipt rec1=recService.increaseOneSec(rec);
      jmsTemplate.convertAndSend("exam3Queue01",rec1);
      System.out.println("Sent the object" +rec1.toString());
      
  }
}
