/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exam3.exam.JMSListener;

import exam3.exam.entities.Receipt;
import exam3.exam.service.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 *
 * @author Mohan
 */
@Component
public class JMSListener {
    @Autowired
    private ReceiptService receiptService;
    
    @JmsListener(destination="exam3Queue01")
    public void receiveMessage(Receipt receipt){
        System.out.println("Message received  "+receipt);
        Receipt receivedReceipt=receiptService.getReceipt(receipt.getId());
        receivedReceipt.setAmount(receipt.getAmount());
        receiptService.save(receivedReceipt);
        
    }
    
}
