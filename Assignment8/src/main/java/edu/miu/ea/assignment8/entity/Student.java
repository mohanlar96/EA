package edu.miu.ea.assignment8.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Student {
  @Id
  @GeneratedValue
  private Long id;
  private String name;
  private float gpa;

  public Student() {
  }

  public Student(String name, float gpa) {
    this.name = name;
    this.gpa = gpa;
  }

  public String getName() {
    return name;
  }

  public Student setName(String name) {
    this.name = name;
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
}
