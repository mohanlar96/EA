package edu.miu.ea.assignment9.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Student {
  @Id
  @GeneratedValue
  private Long id;
  private String firstName;
  private String lastName;
  private float gpa;

  public Student() {
  }

  public Student(String firstName, String lastName, float gpa) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.gpa = gpa;
  }

  public String getLastName() {
    return lastName;
  }

  public Student setLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public String getFirstName() {
    return firstName;
  }

  public Student setFirstName(String name) {
    this.firstName = name;
    return this;
  }

  public float getGpa() {
    return gpa;
  }

  public Student setGpa(float gpa) {
    this.gpa = gpa;
    return this;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getId() {
    return id;
  }

  @Override
  public String toString() {
    return "Student{" +
        "firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        ", gpa=" + gpa +
        '}';
  }
}
