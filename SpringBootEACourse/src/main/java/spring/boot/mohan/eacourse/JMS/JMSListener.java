/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spring.boot.mohan.eacourse.JMS;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import spring.boot.mohan.eacourse.entities.Student;

/**
 *
 * @author Mohan
 */
@Component
public class JMSListener {
    
    @JmsListener(destination="studentQueue")
    public void receiveMessage(Student student){
        System.out.println("Message received  "+student);
    }
    
}
