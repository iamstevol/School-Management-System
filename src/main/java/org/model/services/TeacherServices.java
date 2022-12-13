package org.model.services;

import org.model.model.Teacher;

public interface TeacherServices {
    void teacherCanTakeACourse(String courseName, String courseCode, Teacher teacher);

}
