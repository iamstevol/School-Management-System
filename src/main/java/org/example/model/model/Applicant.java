package org.example.model.model;

public class Applicant extends User{
    private String classApplied;

    public Applicant(String name, int age, String gender, String classApplied) {
        super(name, age, gender);
        this.classApplied = classApplied;
    }

    public String getClassApplied() {
        return classApplied;
    }

    public void setClassApplied(String classApplied) {
        this.classApplied = classApplied;
    }

    @Override
    public String toString() {
        return "Applicant{" +
                "classApplied='" + classApplied + '\'' +
                "} " + super.toString();
    }
}
