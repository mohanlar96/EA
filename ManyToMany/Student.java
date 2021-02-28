/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.miu.second;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;



/**
 *
 * @author black
 */
@Entity

public class Student implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String Name;
    
    private Double gpa;


    public void setName(String Name) {
        this.Name = Name;
    }

    public void setGpa(Double gpa) {
        this.gpa = gpa;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    @OneToMany(mappedBy="student" ,cascade=CascadeType.PERSIST)
    private List<Book> books;

    public List<Book> getBooks() {
        return books;
    }
     public void setBooks(List<Book> books) {
        this.books = books;
    }
    
    
    @ManyToMany(mappedBy="student",cascade=CascadeType.PERSIST)
    public List<Course> courses;

    public void setCourses(List<Course> courses) {
        this.courses = courses;
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
        if (!(object instanceof Student)) {
            return false;
        }
        Student other = (Student) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.ea.Student[ id=" + id + " ]";
    }

    
}
