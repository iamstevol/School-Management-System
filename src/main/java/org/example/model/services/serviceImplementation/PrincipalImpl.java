package org.example.model.services.serviceImplementation;

import org.example.model.model.Applicant;
import org.example.model.model.Staff;
import org.example.model.model.Student;
import org.example.model.services.PrincipalServices;
import org.example.model.utils.Implementation.StaffUtilsImpl;
import org.example.model.utils.Implementation.StudentUtilsImpl;

public class PrincipalImpl implements PrincipalServices {

    StaffUtilsImpl staffUtilsImpl = new StaffUtilsImpl();
    StudentUtilsImpl studentUtilsImpl = new StudentUtilsImpl();
    final int maxAge =30;
    final int minAge = 11;

    public void principalCanAdmitAnApplicant(Staff principal, Applicant applicant) {
        if (applicant.getAge() < minAge || applicant.getAge() > maxAge) {
            System.out.println("Sorry " + applicant.getName() + ", you cannot be admitted due to age restriction.");
        } else {
            studentUtilsImpl.admitApplicant(applicant);
        }
    }

    public void principalCanExpelAStudent(Staff principal, Student student, boolean violateRule) {
        if (student.isViolateRule() == violateRule) {
            System.out.println(principal.getName()+ " cannot " + student.getName());
        } else {
            studentUtilsImpl.expelStudent(student);
        }
    }
}


