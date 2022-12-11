package org.example.model.services.serviceImplementation;

import org.example.model.model.Courses;
import org.example.model.model.Student;
import org.example.model.services.StudentServices;
import org.example.model.utils.Implementation.StudentUtilsImpl;

import java.util.List;

public class StudentImpl implements StudentServices {
    StudentUtilsImpl studentUtilsImpl = new StudentUtilsImpl();

    public void studentCanTakeCourse(String courseName, String courseCode, Student student1){
//        List<Courses> newCourseList = student1.getCourses();
        for(int i=0; i<student1.getCourses().size(); i++){
            if(student1.getCourses().get(i).getCourseName().equalsIgnoreCase(courseName)){
//
//                System.out.println(student1.getName()+ " can take " + courseName);
            }else{
                studentUtilsImpl.addCourseToStudent(student1, courseName, courseCode);
            }
        }
    }
}
