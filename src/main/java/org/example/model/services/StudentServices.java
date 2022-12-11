package org.example.model.services;

import org.example.model.model.Courses;
import org.example.model.model.Staff;
import org.example.model.model.Student;

import java.util.List;

public interface StudentServices {
    void studentCanTakeCourse(String courseName, String courseCode, Student student1);
}
