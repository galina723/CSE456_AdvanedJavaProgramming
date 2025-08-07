package org.example.demo.config;

import jakarta.annotation.PostConstruct;
import org.example.demo.entity.Student;
import org.springframework.stereotype.Component;

import java.util.*;

@Component //giao cho spring quản lý => bean
public class initStudent {

    private List<Student> students;

    //hàm khơi tạo ds hard-code
    @PostConstruct //tự chạy khi khởi tạo obj initStudent
    public void initStudent() {

        students = new ArrayList<>();
        students.add(new Student(1, "Anna", 2000, 95));
        students.add(new Student(2, "Julia", 2001, 96));
        students.add(new Student(3, "Maria", 2002, 87));
        students.add(new Student(4, "David", 1999, 100));
        students.add(new Student(5, "Maria", 1997, 93));
        students.add(new Student(6, "Maria", 1998, 99));
    }

    public List<Student> getStudents() {
        return students;
    }
    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
