import org.example.model.enums.StaffRoles;
import org.example.model.enums.Authority;
import org.example.model.model.*;
import org.example.model.services.serviceImplementation.PrincipalImpl;
import org.example.model.services.serviceImplementation.StudentImpl;
import org.example.model.services.serviceImplementation.TeacherImpl;
import org.example.model.utils.CourseUtils;
import org.example.model.utils.StaffUtils;
import org.example.model.utils.StudentUtils;
//import org.example.model.utils.StudentUtils;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //since the authority of principal is two, I used list<Authority>
        List<Authority> authorityList = new ArrayList<>(Arrays.asList(Authority.ADMIT, Authority.EXPEL));
//        Principal principal = new Principal("Mr Babalola Elijah", 52, "Male","AIF001","BSc", StaffRoles.PRINCIPAL, authorityList);

        Courses course1 = new Courses("BIOLOGY", "101");
        Courses course2 = new Courses("MATHS", "107");
        Courses courses3 = new Courses("PHYSICS", "105");
        List<Courses> courseList = new ArrayList<>(Arrays.asList(course1, course2, courses3));

        //Two teachers with different parameters
        Teacher teacher1 = new Teacher("Mr Thompson John", 45, "Male","BIF001","BSc",StaffRoles.TEACHER,courseList);
        Teacher teacher2 = new Teacher("Mr Akin Idowu", 37, "Male","BIF002", "BSc",StaffRoles.TEACHER, courseList);
        List<Teacher> teacherList = new ArrayList<>(Arrays.asList(teacher1, teacher2));


        //Three students
        Student student1 = new Student("David Ogbonna", 12, "Male", 001, courseList,false);
        Student student2 = new Student("Delight Opoola", 13, "Male", 002, courseList, false);
        Student student3 = new Student("Morenikeji Olabode", 14, "Female",003, courseList, false);
        List<Student> studentList = new ArrayList<>(Arrays.asList(student1, student2,  student3));

        //Applicant
        Applicant applicant = new Applicant("Abubakar Samson", 15, "Male","jjn");

        StudentImpl studentImpl= new StudentImpl();
//        System.out.println(studentImpl.studentCanTakeCourse("GST",110,student1,courseList));
//        PrincipalImpl principalService = new PrincipalImpl();
//        System.out.println(principalService.principalCanAdmitAnApplicant(principal, applicant, 23));
//        System.out.println(principalService.principalCanExpelAStudent(principal, student2, true));
//        TeacherImpl teacherImpl = new TeacherImpl();
//
//        System.out.println(teacherImpl.teacherCanTakeACourse("Maths",111,teacher1));

        StudentUtils studentUtils = new StudentUtils();
        List<Student> students = studentUtils.readStudentFile();
        students.forEach(System.out::println);

        CourseUtils courseUtils = new CourseUtils();
        List<Courses> coursesList = courseUtils.readFile();
        System.out.println(coursesList);


        TeacherImpl teacherImpl = new TeacherImpl();
        StudentImpl studentImpl1 = new StudentImpl();
        PrincipalImpl principalImpl = new PrincipalImpl();

        StaffUtils staffUtils = new StaffUtils();
        CourseUtils courseUtil = new CourseUtils();
        StudentUtils studentUtil = new StudentUtils();
        List<Student> studentList1 = studentUtil.readStudentFile();
        List<Teacher> teachers = staffUtils.readTeacherFile();
        Staff principal1 = staffUtils.readPrincipalFile();
        System.out.println(principal1);
        List<Courses> courseList1 = courseUtil.readFile();
        teachers.forEach(System.out::println);
        courseList1.forEach(System.out::println);
        teacherImpl.teacherCanTakeACourse("CHEM", "101", teachers.get(0));
        studentList1.forEach(System.out::println);
        System.out.println(studentUtil.readHeader());
//        principalImpl.expelStudent("Bad", true, principal1, studentList.get(1));
//        System.out.println(principalImpl.canAdmitApplicant(applicant1, principal1));
//        principalImpl.admitApplicant(applicant2, principal1);
    }

}