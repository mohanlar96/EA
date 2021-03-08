package edu.miu.ea.assignment10.entity;


import javax.persistence.*;
import java.util.List;

@Entity
public class Student {
  @Id
  @GeneratedValue
  private Long id;
  private String firstName;
  private String lastName;
  @OneToMany
  @JoinColumn(name = "student_id")
  private List<Transcript> transcriptList;
  @ManyToMany
  @JoinColumn(name = "student_id")
  private List<Course> courses;

  public List<Transcript> getTranscriptList() {
    return transcriptList;
  }

  public Student setTranscriptList(List<Transcript> transcriptList) {
    this.transcriptList = transcriptList;
    return this;
  }

  public List<Course> getCourses() {
    return courses;
  }

  public Student setCourses(List<Course> courses) {
    this.courses = courses;
    return this;
  }

  public Student() {
  }

  public Student(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
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
        '}';
  }
}
