package org.example.model.utils;

import org.example.model.enums.StaffRoles;
import org.example.model.model.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class StaffUtils {

    StudentUtils studentUtils = new StudentUtils();
    private final String FILE = "src/main/resources/Staff - Sheet1 (1).csv";


    public List<Teacher> readTeacherFile() {
        // The CourseUtils was created here to pass in the read courseFile into a new
        // courseList for studentUtils
        CourseUtils courseUtils = new CourseUtils();
        List<Courses> courses = courseUtils.readFile();

        // New studentList to compare the courseCode
        List<Teacher> teacherList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(FILE))) {
            br.readLine();
            br.readLine();
            String line = "";
            while ((line = br.readLine()) != null) {

                // to split the file by comma
                String[] column = line.split(",");

                //new studentCourseList initiated to store the new generated courseList
                List<Courses> teacherCourseList = new ArrayList<>();

                //to split the courses in student list
                String[] teacherCourses = column[6].substring(1, column[6].length() - 1).split(" ");

                //loop through to check if the course correlates with any of the newCourseList
                for (String str : teacherCourses) {
                    for (Courses courseList : courses) {
                        if (Objects.equals(courseList.getCourseName(), str)) {
                            teacherCourseList.add(courseList);
                        }
                    }
                }
                teacherList.add(new Teacher(column[0], Integer.parseInt(column[1]), column[2], column[3], column[4], StaffRoles.TEACHER, teacherCourseList));


            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return teacherList;
    }

    public Staff readPrincipalFile() {
        Staff principal = null;
        try (BufferedReader br = new BufferedReader(new FileReader(FILE))) {
            br.readLine();
            String[] column = br.readLine().split(",");
//            String line = "";
//            String[] column = line.split(",");
            principal = new Staff(column[0], Integer.parseInt(column[1]), column[2], column[3], column[4], StaffRoles.PRINCIPAL);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return principal;
    }

    public void expelStudent(Student student) {
        List<Student> studentList = studentUtils.readStudentFile();
        int index = 0;
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getName() == student.getName()) {
                index = i;
            }
        }
        studentList.remove(studentList.get(index));

        try (BufferedWriter br = new BufferedWriter(new FileWriter("src/main/resources/StudentDOC - Sheet1 (1).csv"))) {
            StringBuilder st = new StringBuilder();
            for (Student student1 : studentList) {
                st.append(student1.getName()).append(",");
                st.append(student1.getAge()).append(",");
                st.append(student1.getGender()).append(",");
                st.append(student1.getStudentId()).append(",");
                st.append(student1.getCourses().stream().map(Courses::getCourseName).collect(Collectors.joining(" "))).append(",");
                st.append(student1.isViolateRule()).append("\n");
            }
            br.write(st.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Student has been expelled");
    }



    public void admitApplicant(Applicant applicant, Student student) {
        List<Student> studentList = studentUtils.readStudentFile();

        Courses courses1 = new Courses("MATH", "107");
        Courses courses2 = new Courses("BIO", "107");
        List<Courses> courses = new ArrayList<>(Arrays.asList(courses1, courses2));

        studentList.add(new Student(applicant.getName(), applicant.getAge(), applicant.getGender(), 001, courses, false));

        try (BufferedWriter br = new BufferedWriter(new FileWriter("src/main/resources/StudentDOC - Sheet1 (1).csv"))) {
            StringBuilder st = new StringBuilder();
            for (Student student1 : studentList) {
                st.append(student1.getName()).append(",");
                st.append(student1.getAge()).append(",");
                st.append(student1.getGender()).append(",");
                st.append(student1.getStudentId()).append(",");
                st.append(student1.getCourses().stream().map(Courses::getCourseName).collect(Collectors.joining(" "))).append(",");
                st.append(student1.isViolateRule()).append("\n");
            }
            br.write(st.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Applicant has been admitted");
    }

    public void addCourseToTeacher(Teacher teacher, String courseName, String courseCode){
        List<Teacher> teacherList = readTeacherFile();
        for(Teacher teacher1 : teacherList){
            if(Objects.equals(teacher1.getName(), teacher1.getName())){
                teacher1.getCourses().add(new Courses(courseName, courseCode));
            }
        }
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/main/resources/Staff - Sheet1 (1).csv"))){
            StringBuilder st = new StringBuilder();
            StaffUtils staffUtil1 = new StaffUtils();
            st.append(staffUtil1.readPrincipalFile().getName()).append("\t");
            st.append(staffUtil1.readPrincipalFile().getAge()).append("\t");
            st.append(staffUtil1.readPrincipalFile().getGender()).append("\t");
            st.append(staffUtil1.readPrincipalFile().getStaffID()).append("\t");
            st.append(staffUtil1.readPrincipalFile().getQualification()).append("\t");
            st.append(staffUtil1.readPrincipalFile().getStaffRoles()).append("\t");
            st.append("\n");
            for(Teacher list : teacherList) {
                st.append(list.getName()).append("\t");
                st.append(list.getAge()).append("\t");
                st.append(list.getGender()).append("\t");
                st.append(list.getStaffID()).append("\t");
                st.append(list.getQualification()).append("\t");
                st.append(list.getStaffRoles()).append("\t");
                st.append(list.getCourses().stream().map(Courses::getCourseName).collect(Collectors.joining(" ", "[", "]")));
                st.append("\n");
            }
            bufferedWriter.write(st.toString());
        }
        catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(teacher.getName() + " can now take Course");
    }

}

