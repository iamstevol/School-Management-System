package org.example.model.services.serviceImplementation;

import org.example.model.model.Courses;
import org.example.model.model.Staff;
import org.example.model.model.Student;
import org.example.model.services.StudentServices;
import org.example.model.utils.StudentUtils;

import java.util.List;

public class StudentImpl implements StudentServices {
    StudentUtils studentUtils = new StudentUtils();

    public void studentCanTakeCourse(String courseName, String courseCode, Student student1, List<Courses> courseList){
        List<Courses> newCourseList = student1.getCourses();
        for(int i=0; i<courseList.size(); i++){
            if(student1.getCourses().get(i).getCourseName().equalsIgnoreCase(courseName)){
                System.out.println(student1.getName()+ " can take " + courseName);
            }
        }
        studentUtils.addCourseToStudent(student1, courseName, courseCode);
        System.out.println(student1.getName() + " cannot take " + courseCode);
    }
}
