/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.miu.mohan.assignment4;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.LockModeType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Version;

/**
 *
 * @author mohan
 */
  //1- Write a named query to return all books for a students with gpa >= 3.0.
@NamedQueries({
 @NamedQuery(name="Student.booksForStudentGpaGTOrEq3",query ="SELECT s.books from Student s where s.gpa>=3.0",lockMode = LockModeType.READ),  
 @NamedQuery(name="Student.booksForStudentGpaGTOrEq3AndPagesGT100",query ="SELECT book from Student s JOIN s.books book where s.gpa>=3.0 and book.pageCount>=100") 
})

@Entity
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }
    @Version private int version;

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
    public void setId(Long id) {
        this.id = id;
    }
    private String name;
    @OneToMany
    private List<Book> books;

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
    public String getName() {
        return name;
    }
    @Column(name="grade")
    private double gpa;

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
    public void setName(String name) {
        this.name = name;
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
        return "edu.miu.mohan.assignment2.crud.Student[ id=" + id + " ]";
    }
    
}
