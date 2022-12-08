package org.example.model.services;

import org.example.model.model.Applicant;
import org.example.model.model.Staff;
import org.example.model.model.Student;

public interface PrincipalServices {
    void principalCanAdmitAnApplicant(Staff principal, Applicant applicant, int age, Student student);
    void principalCanExpelAStudent(Staff principal, Student student, boolean ViolateRule);
}

