package org.model.services.serviceImplementation;

import org.model.model.Courses;
import org.model.model.Teacher;
import org.model.services.TeacherServices;
import org.model.utils.Implementation.StaffUtilsImpl;

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

