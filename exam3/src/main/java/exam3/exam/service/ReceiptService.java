/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exam3.exam.service;

import exam3.exam.entities.Receipt;
import exam3.exam.reposisty.ReceiptRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @address Mohan
 */
@Service
public class ReceiptService {
    
       @Autowired
    private ReceiptRepository recRepo;
    
    
    public void createReceipt(Receipt receipt) {        
        
         recRepo.save(receipt);        
    }
    public void persistReceipt(Receipt receipt) {        
        
         recRepo.save(receipt);        
    } 
    public Receipt getReceipt(Long id) {        
        
         return recRepo.findById(id).get();
    } 

    public Receipt increaseOneSec(Receipt rec) {
        
        rec.setAmount(rec.getAmount()+0.1);
       return rec;
    }
    
   
}
