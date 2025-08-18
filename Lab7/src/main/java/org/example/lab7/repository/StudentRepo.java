package org.example.lab7.repository;

import org.example.lab7.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student, String> {
    List<Student> searchAllByStudentNameContainingIgnoreCase(String name);
}

