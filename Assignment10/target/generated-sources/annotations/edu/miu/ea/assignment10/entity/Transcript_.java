package edu.miu.ea.assignment10.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Transcript.class)
public abstract class Transcript_ {

	public static volatile SingularAttribute<Transcript, Student> student;
	public static volatile SingularAttribute<Transcript, Double> gpa;
	public static volatile SingularAttribute<Transcript, Course> course;
	public static volatile SingularAttribute<Transcript, Long> id;

	public static final String STUDENT = "student";
	public static final String GPA = "gpa";
	public static final String COURSE = "course";
	public static final String ID = "id";

}

