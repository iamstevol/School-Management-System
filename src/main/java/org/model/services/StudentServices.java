package org.model.services;

import org.model.model.Student;

public interface StudentServices {
    void studentCanTakeCourse(String courseName, String courseCode, Student student1);
}
