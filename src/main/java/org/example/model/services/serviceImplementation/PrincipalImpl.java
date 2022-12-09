package org.example.model.services.serviceImplementation;

import org.example.model.model.Applicant;
import org.example.model.model.Staff;
import org.example.model.model.Student;
import org.example.model.services.PrincipalServices;
import org.example.model.utils.StaffUtils;
import org.example.model.utils.StudentUtils;

public class PrincipalImpl implements PrincipalServices {

    StaffUtils staffUtils = new StaffUtils();
    StudentUtils studentUtils = new StudentUtils();
    final int maxAge =30;
    final int minAge = 11;

    public void principalCanAdmitAnApplicant(Staff principal, Applicant applicant, Student student) {
        if (applicant.getAge() < minAge || applicant.getAge() > maxAge) {
            System.out.println("Sorry " + applicant.getName() + ", you cannot be admitted due to age restriction.");
        } else {
            studentUtils.admitApplicant(applicant, student);
        }
    }

    public void principalCanExpelAStudent(Staff principal, Student student, boolean violateRule) {
        if (student.isViolateRule() == violateRule) {
            System.out.println(principal.getName()+ " cannot " + student.getName());
        } else {
            studentUtils.expelStudent(student);
        }
    }
}


