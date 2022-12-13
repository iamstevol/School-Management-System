package org.model.services;

import org.model.model.Applicant;
import org.model.model.Staff;
import org.model.model.Student;

public interface PrincipalServices {
    void principalCanAdmitAnApplicant(Staff principal, Applicant applicant);
    void principalCanExpelAStudent(Staff principal, Student student, boolean ViolateRule);
}

