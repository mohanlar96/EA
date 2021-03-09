package edu.miu.ea.assignment10.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Course.class)
public abstract class Course_ {

	public static volatile SingularAttribute<Course, String> courseName;
	public static volatile ListAttribute<Course, Student> students;
	public static volatile SingularAttribute<Course, Long> id;

	public static final String COURSE_NAME = "courseName";
	public static final String STUDENTS = "students";
	public static final String ID = "id";

}

