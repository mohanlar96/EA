package edu.miu.ea.assignment10.entity;

import javax.persistence.*;

@Entity
public class Transcript {
  @Id
  @GeneratedValue
  private Long id;
  private Double gpa;
  @ManyToOne
  private Student student;
  @OneToOne
  private Course course;

  public Transcript() {
  }

  public Transcript(Double gpa, Student student, Course course) {
    this.gpa = gpa;
    this.student = student;
    this.course = course;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getId() {
    return id;
  }
}
