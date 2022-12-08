package org.example.model.services.serviceImplementation;

import org.example.model.model.Applicant;
import org.example.model.model.Staff;
import org.example.model.model.Student;
import org.example.model.services.PrincipalServices;
import org.example.model.utils.StaffUtils;

public class PrincipalImpl implements PrincipalServices {

    StaffUtils staffUtils = new StaffUtils();
    final int maxAge =30;
    final int minAge = 11;

        public void principalCanAdmitAnApplicant(Staff principal, Applicant applicant, int age, Student student) {
            if (applicant.getAge() < minAge && applicant.getAge() > maxAge) {
                System.out.println("Sorry " + applicant.getName() + " you are not admitted");
            }
            else{
                staffUtils.admitApplicant(applicant, student);
                System.out.println(applicant.getName() + " is not expelled");
            }

        }

        public void principalCanExpelAStudent(Staff principal, Student student, boolean violateRule){
            if (student.isViolateRule() == violateRule){
                System.out.println(student.getName() + " is not expelled");
            }
            else{
                staffUtils.expelStudent(student);
                System.out.println(student.getName() + " is not expelled");
            }

}
}


