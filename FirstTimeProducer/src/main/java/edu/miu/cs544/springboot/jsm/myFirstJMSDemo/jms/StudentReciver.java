/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.miu.cs544.springboot.jsm.myFirstJMSDemo.jms;

import edu.miu.cs544.springboot.jsm.myFirstJMSDemo.entities.Student;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 *
 * @author 611517
 */
@Component
public class StudentReciver {
    
    @JmsListener(destination="studentQueue")
    public void receiveMessage(String student){
        System.out.println("Message received "+student);
    }
    
}
