package edu.miu.ea.assignment10.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Student.class)
public abstract class Student_ {

	public static volatile SingularAttribute<Student, String> firstName;
	public static volatile SingularAttribute<Student, String> lastName;
	public static volatile ListAttribute<Student, Course> courses;
	public static volatile SingularAttribute<Student, Long> id;
	public static volatile ListAttribute<Student, Transcript> transcriptList;

	public static final String FIRST_NAME = "firstName";
	public static final String LAST_NAME = "lastName";
	public static final String COURSES = "courses";
	public static final String ID = "id";
	public static final String TRANSCRIPT_LIST = "transcriptList";

}

