/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.miu.second;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 *
 * @author black
 */
@Entity
public class Course implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Course(String courseName, int level,List<Student> student) {
        this.courseName = courseName;
        this.level = level;
        this.student= student;
    }
    
    public Course(){
    }

   
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setLevel(int level) {
        this.level = level;
    }
    @ManyToMany(targetEntity=Student.class)
    private List<Student> student;

    public void setStudent(List<Student> student) {
        this.student = student;
    }

    
    private String courseName;
    
    private int level;
    
    
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Course)) {
            return false;
        }
        Course other = (Course) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.miu.second.Course[ id=" + id + " ]";
    }
    
}
