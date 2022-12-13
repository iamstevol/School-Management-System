package org.model.services.serviceImplementation;

import org.model.model.Student;
import org.model.services.StudentServices;
import org.model.utils.Implementation.StudentUtilsImpl;

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
