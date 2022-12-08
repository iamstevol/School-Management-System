package org.example.model.utils;

import org.example.model.model.Courses;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CourseUtils {
    public List<Courses> readFile() {

        //New courseList to hold the course file.
        List<Courses> courseList = new ArrayList<>();

        String file = "src/main/resources/CourseDOC - Sheet1.csv";
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            br.readLine();
            String line= "";
            while((line = br.readLine()) !=null) {
                String[] column = line.split(",");

                //Creating new instance of Courses from the course class
                courseList.add(new Courses(column[0], column[1]));
            }
        }catch(IOException e) {
            e.printStackTrace();
        }
        return courseList;
    }
}
