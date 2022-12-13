import org.example.example.model.enums.StaffRoles;
import org.example.example.model.enums.Authority;
import org.example.example.model.model.*;
import org.example.example.model.services.serviceImplementation.PrincipalImpl;
import org.example.example.model.services.serviceImplementation.StudentImpl;
import org.example.example.model.services.serviceImplementation.TeacherImpl;
import org.example.example.model.utils.Implementation.CourseUtilsImpl;
import org.example.example.model.utils.Implementation.StaffUtilsImpl;
import org.example.example.model.utils.Implementation.StudentUtilsImpl;
//import org.example.model.utils.Implementation.StudentUtilsImpl;

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
        Applicant applicant = new Applicant("Abubakar Samson", 15, "Male","jss");
        Applicant applicant1 = new Applicant("Tunde Samson", 18, "Male","jss");


        StudentImpl studentImpl= new StudentImpl();
        PrincipalImpl principalImpl = new PrincipalImpl();
        StaffUtilsImpl staffUtilsImpl = new StaffUtilsImpl();
        List<Teacher> teachers= staffUtilsImpl.readTeacherFile();
        CourseUtilsImpl courseUtil = new CourseUtilsImpl();
        StudentUtilsImpl studentUtil = new StudentUtilsImpl();
        Staff principal1 = staffUtilsImpl.readPrincipalFile();
        List<Student> studentList1 = studentUtil.readStudentFile();
        List<Courses> coursesList = courseUtil.readFile();
        TeacherImpl teacherImpl = new TeacherImpl();

//        studentList1.forEach(System.out::println);
//        courseList.forEach(System.out::println);
//        staffUtilsImpl.readTeacherFile().forEach(System.out::println);
//        teacherImpl.teacherCanTakeACourse("GEOGRAPHY", "GEO101", teachers.get(1));
//        studentImpl.studentCanTakeCourse("GEOGRAPHY", "GEO101", studentList1.get(1));
//        principalImpl.principalCanAdmitAnApplicant(principal1, applicant);
        principalImpl.principalCanExpelAStudent(principal1, studentList1.get(2), true);
    }
}