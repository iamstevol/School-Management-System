package org.example.model.services;

import org.example.model.model.Staff;
import org.example.model.model.Teacher;

public interface TeacherServices {
    void teacherCanTakeACourse(String courseName, String courseCode, Teacher teacher);

}
