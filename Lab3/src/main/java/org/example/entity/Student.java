package org.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "Student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "studentId", columnDefinition = "BIGINT")
    private String studentId;
    @Column(name = "fullName", columnDefinition = "VARCHAR(100)", nullable = false)
    private String fullName;
    @Column(name = "gender", nullable = false)
    private Gender gender;
    @Column(name = "dob", nullable = false)
    private LocalDate dob;
    @Column(name = "Gpa")
    private double gpa;
    @Column(name = "enrollmentYear",  nullable = false)
    private int enrollmentYear;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "majorId")
    private Major major;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "schoolId")
    private School school;

    public Student(String fullName, Gender gender, LocalDate dob, double gpa, int enrollmentYear) {
        this.fullName = fullName;
        this.gender = gender;
        this.dob = dob;
        this.gpa = gpa;
        this.enrollmentYear = enrollmentYear;
    }
}
