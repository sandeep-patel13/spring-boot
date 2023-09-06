package com.example.demo.students;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class StudentConfig {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentConfig(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Bean
    public void getStudents() {

        List<Student> students = new ArrayList<>();
        try {
                String str = "2002-13-11";
                SimpleDateFormat format = new SimpleDateFormat("yyy-mm-dd");
                java.util.Date udate = format.parse(str);
                java.sql.Date dob = new java.sql.Date(udate.getTime());
                students.add(new Student(1L, "Sande Patel", 21, dob, "sandeepp3579@gmail.com"));
                students.add(new Student(20L, "jhon deek", 35, dob, "jhon@gmail.com"));
                students.add(new Student(7L, "yesh sudan", 19, dob, "yash@gmail.com"));
                students.add(new Student(13L, "jizze", 81, dob, "jizze@gmail.com"));
                students.add(new Student(90L, "abhimz", 65, dob, "abhimz@gmail.com"));
//                return students;
        }
        catch(ParseException pe) {
            pe.printStackTrace();
//            return students;
        }
        studentRepository.saveAll(students);

    }



}
