/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.miu.mohan.assignment10_1;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.scheduling.annotation.Scheduled;

/**
 *
 * @author mohan
 */
public class MyTimer {
    @Scheduled(fixedRate = 5000,initialDelay = 5000)
    public void myMethod(){
        System.out.println("");
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();
        System.out.println("Time:"+ dateFormat.format(date));
        
    }
}
