package com.example.demo.students;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudent() {
        return studentRepository.findAll();
    }

    public void registerStudent(Student student) {

        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
        if(studentOptional.isPresent()){
            throw new IllegalStateException("email taken...");
        }
        else {
            studentRepository.save(student);
        }
    }

    public void deleteStudent(Long id) {

        if(studentRepository.existsById(id))
            studentRepository.deleteById(id);
        else {
            throw new IllegalStateException("id doesn't exist");
        }

    }

    public void updateStudent(Long id , String name) {

        if(studentRepository.existsById(id)) {
            System.out.println("yes...");
            studentRepository.updateStudentById(id , name);
        }
        else {
            throw new IllegalStateException("id doesn't exist , cant update....");
        }

    }
}




