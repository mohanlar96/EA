/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.miu.cs544.springboot.jsm.myFirstJMSDemo.myJMSController;

import edu.miu.cs544.springboot.jsm.myFirstJMSDemo.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author 611517
 */
@RestController
public class StudentJMSController {
    @Autowired
    private JmsTemplate jmsTemplate;
    
    @PostMapping
    public void sendMsg(@RequestBody Student student){
   
        System.out.println("Post student is "+student);
        jmsTemplate.convertAndSend("StudentQueue",student);
        System.out.println("working");
        
    }
}
