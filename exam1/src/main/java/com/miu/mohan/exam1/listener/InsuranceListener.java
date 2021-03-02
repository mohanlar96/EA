/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miu.mohan.exam1.listener;

import com.miu.mohan.exam1.entities.Insurance;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PostUpdate;

/**
 *
 * @author 611517
 */

public class InsuranceListener  {

    @PostUpdate
    public void doThings(Insurance ins){
        System.out.println("Updated the insurance "+ins.getId()+" Detailed :"+ins);
        
    }
    
    
}
