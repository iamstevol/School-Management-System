package org.example.model.model;

import org.example.model.enums.Authority;
import org.example.model.enums.StaffRoles;

import java.util.List;

public class Teacher extends Staff{
    private List<Courses> courses;

    public Teacher(String name, int age, String gender, String staffID, String qualification, StaffRoles staffRoles, List<Courses> courses) {
        super(name, age, gender, staffID, qualification, staffRoles);
        this.courses = courses;
    }

    public List<Courses> getCourses() {
        return courses;
    }

    public void setCourses(List<Courses> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "courses=" + courses +
                "} " + super.toString();
    }
}
