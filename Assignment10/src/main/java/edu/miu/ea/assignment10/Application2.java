package edu.miu.ea.assignment10;

import edu.miu.ea.assignment10.config.AccountEntryLogging;
import edu.miu.ea.assignment10.config.ApplicationConfig;
import edu.miu.ea.assignment10.entity.AccountEntry;
import edu.miu.ea.assignment10.entity.Course;
import edu.miu.ea.assignment10.entity.Student;
import edu.miu.ea.assignment10.entity.Transcript;
import edu.miu.ea.assignment10.service.PersistenceService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class Application2 {
  public static void main(String[] args) {

    System.out.println("step 1 ************************************************************************************************");
    ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
    System.out.println("step 2 ************************************************************************************************");
    PersistenceService persistenceService = context.getBean("persistenceService",PersistenceService.class);
    System.out.println("step 3 ************************************************************************************************");
    Student nam = new Student("Nam","Nguyen");
    List<Course> courseList = new ArrayList<>();
    Course course1 = new Course("EA");
    Course course2 = new Course("ASD");
    courseList.add(course1);
    courseList.add(course2);
//    nam.setCourses(courseList);
    List<Transcript> transcriptList = new ArrayList<>();
    Transcript transcript = new Transcript(3.2d,nam,course1);
    Transcript transcript1 = new Transcript(3.4d,nam,course2);
    transcriptList.add(transcript);
    transcriptList.add(transcript1);
//    nam.setTranscriptList(transcriptList);
    persistenceService.insertAll(nam,transcriptList,courseList);

    System.out.println("step 4 ************************************************************************************************");

  }
}
