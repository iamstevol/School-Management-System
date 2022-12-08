package org.example.model.utils;

import org.example.model.enums.StaffRoles;
import org.example.model.model.Courses;
import org.example.model.model.Staff;
import org.example.model.model.Student;
import org.example.model.model.Teacher;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class StudentUtils {
    private String file = "src/main/resources/StudentDOC - Sheet1 (1).csv";
    public List<Student> readStudentFile() {
        // The CourseUtils was created here to pass in the read courseFile into a new
        // courseList for studentUtils
        CourseUtils courseUtils =new CourseUtils();
        List<Courses> courses = courseUtils.readFile();

        // New studentList to compare the courseCode
        List<Student> studentList = new ArrayList<>();


        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            br.readLine();
            String line ="";
            while ((line=br.readLine()) !=null) {

                // to split the file by comma
                String[] column = line.split(",");

                //new studentCourseList initiated to store the new generated courseList
                List<Courses> studentCourseList = new ArrayList<>();

                //to split the courses in student list
                String[] studentCourses = column[4].substring(1, column[4].length()-1).split(" ");

                //loop through to check if the course correlates with any of the newCourseList
                for ( String str : studentCourses) {
                    for (Courses courseList : courses) {
                        if (Objects.equals(courseList.getCourseName(), str)) {
                            studentCourseList.add(courseList);
                        }
                    }
                }
                studentList.add(new Student(column[0], Integer.parseInt(column[1]), column[2], Integer.parseInt(column[3]), studentCourseList, Boolean.parseBoolean(column[5])));


            }
        } catch(IOException e) {
            e.printStackTrace();
        }
        return studentList;
    }

    public List<String> readHeader() {
        List<String> header = new ArrayList<>();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String[] column = bufferedReader.readLine().split(",");
            header.addAll(Arrays.asList(column[0], column[1], column[2], column[3], column[4], column[5]));
        }catch(IOException e){
            e.printStackTrace();
        }
        return header;
    }

    public void addCourseToStudent(Student student, String courseName, String courseCode){
        List<Student> studentList = readStudentFile();
        for(Student student1 : studentList){
            if(Objects.equals(student1.getName(), student1.getName())){
                student1.getCourses().add(new Courses(courseName, courseCode));
            }
        }
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/main/resources/StudentDOC - Sheet1 (1).csv"))){
            StringBuilder st = new StringBuilder();
            for(Student list : studentList) {
                st.append(list.getName()).append("\t");
                st.append(list.getAge()).append("\t");
                st.append(list.getGender()).append("\t");
                st.append(list.getStudentId()).append("\t");
                st.append(list.getCourses().stream().map(Courses::getCourseName).collect(Collectors.joining(" ", "[", "]")));
                st.append(list.isViolateRule()).append("\t");
                st.append("\n");
            }
            bufferedWriter.write(st.toString());
        }
        catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(student.getName() + " course list has been updated successfully");
    }
}

