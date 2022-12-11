package org.example.model.utils.Implementation;

import org.example.model.enums.StaffRoles;
import org.example.model.model.*;
import org.example.model.utils.StaffUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class StaffUtilsImpl implements StaffUtils {

    StudentUtilsImpl studentUtilsImpl = new StudentUtilsImpl();
    private final String FILE = "src/main/resources/Staff - Sheet1 (1).csv";


    public List<Teacher> readTeacherFile() {
        // The CourseUtilsImpl was created here to pass in the read courseFile into a new
        // courseList to compare with the Teacher courseList
        CourseUtilsImpl courseUtilsImpl = new CourseUtilsImpl();
        List<Courses> courses = courseUtilsImpl.readFile();

        // New studentList to compare the courseCode
        List<Teacher> teacherList = new ArrayList<>();

        String line = "";
        try (BufferedReader br = new BufferedReader(new FileReader(FILE))) {
            br.readLine();
            br.readLine();
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
            principal = new Staff(column[0], Integer.parseInt(column[1]), column[2], column[3], column[4], StaffRoles.PRINCIPAL);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return principal;
    }


    public void addCourseToTeacher(Teacher teacher, String courseName, String courseCode) {
        List<Teacher> teacherList = readTeacherFile();
        for (Teacher teacher1 : teacherList) {
            if (Objects.equals(teacher1.getName(), teacher.getName())) {
                teacher1.getCourses().add(new Courses(courseName, courseCode));
            }
        }
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/main/resources/Staff1 - Sheet1 (1).csv"))) {
            StringBuilder st = new StringBuilder();
            StaffUtilsImpl staffUtil1 = new StaffUtilsImpl();
            st.append(staffUtil1.readPrincipalFile().getName()).append("\t");
            st.append(staffUtil1.readPrincipalFile().getAge()).append("\t");
            st.append(staffUtil1.readPrincipalFile().getGender()).append("\t");
            st.append(staffUtil1.readPrincipalFile().getStaffID()).append("\t");
            st.append(staffUtil1.readPrincipalFile().getQualification()).append("\t");
            st.append(staffUtil1.readPrincipalFile().getStaffRoles()).append("\t");
            st.append("\n");
            for (Teacher list : teacherList) {
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
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(teacher.getName() + " course list has been updated successfully");
    }
}

