package org.example.services;

import org.example.entity.Student;
import org.example.repositories.StudentRepo;

import java.util.List;

public class StudentService {
    public void createStudent(Student student){
        StudentRepo.saveStudent(student);
    }
    public void updateStudent(Student student){
        StudentRepo.updateStudent(student);
    }
    public void deleteStudent(Student student){
        StudentRepo.deleteStudent(student);
    }
    public Student getStudentByID(int id){
        return StudentRepo.findStudentById(id);
    }
    public List<Student> getAllStudents(){
        return StudentRepo.findAll();
    }
}
