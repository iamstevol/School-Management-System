package org.model.services.serviceImplementation;

import org.model.model.Applicant;
import org.model.model.Staff;
import org.model.model.Student;
import org.model.services.PrincipalServices;
import org.model.utils.Implementation.StaffUtilsImpl;
import org.model.utils.Implementation.StudentUtilsImpl;

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


