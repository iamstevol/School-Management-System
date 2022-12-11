package org.example.model.services.serviceImplementation;

import org.example.model.model.Courses;
import org.example.model.model.Teacher;
import org.example.model.services.TeacherServices;
import org.example.model.utils.Implementation.StaffUtilsImpl;

import java.util.List;

public class TeacherImpl implements TeacherServices {
    private final StaffUtilsImpl staffUtilsImpl = new StaffUtilsImpl();
    public void teacherCanTakeACourse(String courseName, String courseCode, Teacher teacher) {
        List<Courses> coursesList = teacher.getCourses();
        for (int i = 0; i < coursesList.size(); i++) {
            if (teacher.getCourses().get(i).getCourseName().equalsIgnoreCase(courseName)) {
                System.out.println(teacher.getName() + " currently takes this " + courseName);
            }
        }
        staffUtilsImpl.addCourseToTeacher(teacher, courseName, courseCode);
    }
}

