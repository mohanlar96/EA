/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.miu.mohan.assignment8_1.persisters;

import edu.miu.mohan.assignment8_1.entities.Student;
import javax.persistence.EntityManager;

/**
 *
 * @author mohan
 */
public interface StudentPersister {
    public void Save(EntityManager em, Student student);
}
