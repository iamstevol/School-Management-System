package org.example.model.model;

import java.util.List;

public class Student extends User {
    private int studentId;
    private List<Courses> courses;
    private boolean isViolateRule;


    public Student(String name, int age, String gender, int studentId, List<Courses> courses, boolean isViolateRule) {
        super(name, age, gender);
        this.studentId = studentId;
        this.courses = courses;
        this.isViolateRule = isViolateRule;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public List<Courses> getCourses() {
        return courses;
    }

    public void setCourses(List<Courses> courses) {
        this.courses = courses;
    }

    public boolean isViolateRule() {
        return isViolateRule;
    }

    public void setViolateRule(boolean violateRule) {
        isViolateRule = violateRule;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", studentId:" + studentId +
                ", courses:" + courses +
                ", isViolateRule:" + isViolateRule +
                "} ";
    }
}

