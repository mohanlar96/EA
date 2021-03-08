package edu.miu.ea.assignment10.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class Course {
  private String courseName;
  @Id
  @GeneratedValue
  private Long id;

  @ManyToMany(mappedBy = "courses")
  private List<Student> students;

  public Course() {
  }

  public Course(String courseName) {
    this.courseName = courseName;
  }

  public List<Student> getStudents() {
    return students;
  }

  public Course setStudents(List<Student> students) {
    this.students = students;
    return this;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getId() {
    return id;
  }

  public String getCourseName() {
    return courseName;
  }

  public Course setCourseName(String courseName) {
    this.courseName = courseName;
    return this;
  }
}
