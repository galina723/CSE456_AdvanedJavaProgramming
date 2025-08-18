package org.example.lab7.service;


import org.example.lab7.model.Student;
import org.example.lab7.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepo sr;

    public void saveStudent(Student s){
        sr.save(s);
    }

    public List<Student> getStudentList(){
        return sr.findAll();
    }

    public void deleteStudentById(String studentId){
        sr.deleteById(studentId);
    }

    public List<Student> searchStudentByName(String keyword){
        return sr.searchAllByStudentNameContainingIgnoreCase(keyword);
    }

    public boolean checkStudentExistById(String id){
        return sr.existsById(id);
    }
}

