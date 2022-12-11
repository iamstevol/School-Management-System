package org.example.model.model;

import java.util.List;

public class Courses {
    private String courseName;
    private String courseCode;

    public Courses(String courseName, String courseCode) {
        this.courseName = courseName;
        this.courseCode = courseCode;

    }


    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        courseName = courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        courseCode = courseCode;
    }

    @Override
    public String toString() {
        return
                "courseName:" + courseName +
                ", courseCode:" + courseCode
                ;
    }
}
