package org.example;

import jakarta.persistence.EntityManager;
import org.example.entity.Gender;
import org.example.entity.Major;
import org.example.entity.School;
import org.example.entity.Student;
import org.example.infras.javaUtil;
import org.example.repositories.MajorRepo;
import org.example.repositories.SchoolRepo;
import org.example.repositories.StudentRepo;
import org.example.services.MajorService;
import org.example.services.SChoolService;
import org.example.services.StudentService;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        School school1 = new School("EIU", "Eastern International University", "TpHcm");
        School school2 = new School("BDU", "Binh Duong University", "TpHcm");
        School school3 = new School("VLU", "Van Lang University", "TpHcm");

        Major major1 = new Major("CSE", "Software Engineering");
        Major major2 = new Major("NUR", "Nursing");
        Major major3 = new Major("BUS", "Business Administration");

        Student student1 = new Student("Anna", Gender.FEMALE, LocalDate.parse("2000-01-01"), 3.2, 2018);
        Student student2 = new Student("Adam",  Gender.MALE, LocalDate.parse("2001-11-21"), 3.0, 2019);
        Student student3 = new Student("David", Gender.MALE, LocalDate.parse("2003-05-30"), 2.93, 2021);
        Student student4 = new Student("Adam",  Gender.MALE, LocalDate.parse("2002-08-02"), 3.7, 2020);

        major1.addStudent(student1);
        major1.addStudent(student2);

        school1.addStudent(student1);
        school2.addStudent(student3);
        school3.addStudent(student4);
        school3.addStudent(student2);

        school3.addMajor(major3);
        school1.addMajor(major2);

        SchoolRepo schoolRepo = new SchoolRepo();
        SChoolService schoolService = new SChoolService();
        schoolService.createSchool(school1);
        schoolService.createSchool(school2);
        schoolService.createSchool(school3);

        MajorRepo majorRepo = new MajorRepo();
        MajorService majorService = new MajorService();
        majorService.createMajor(major1);
        majorService.createMajor(major2);
        majorService.createMajor(major3);

        StudentRepo studentRepo = new StudentRepo();
        StudentService studentService = new StudentService();
        studentService.createStudent(student1);
        studentService.createStudent(student2);
        studentService.createStudent(student3);

    }
}