package com.example.demo.students;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping // handeling data getting request
    public List<Student> getStudent() {
       return studentService.getStudent();
    }

    @PostMapping("/sendObject") //handeling data storing request
    public void registerNewStudents(@RequestBody Student student) {

        studentService.registerStudent(student);

    }

    @DeleteMapping
    public void deleteStudentBasedOnId(@RequestParam Long id) {

        studentService.deleteStudent(id);

    }

    @PutMapping
    public void updateStudent(@RequestParam Long id , String name) {

        System.out.println(id + name);
        studentService.updateStudent(id , name);

    }
}
