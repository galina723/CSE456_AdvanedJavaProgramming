package org.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "School")
public class School {
    @Id
    @Column(name = "schoolId", columnDefinition = "CHAR(3)")
    private String schoolId;
    @Column(name = "schoolName", columnDefinition = "VARCHAR(100)", nullable = false)
    private String schoolName;
    @Column(name = "location", columnDefinition = "VARCHAR(100)", nullable = true)
    private String location;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "school")
    List<Student> students =  new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
        student.setSchool(this);
    }

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "school")
    List<Major> majors =  new ArrayList<>();

    public void addMajor(Major major) {
        majors.add(major);
        major.setSchool(this);
    }

    public School(String schoolId, String schoolName, String location) {
        this.schoolId = schoolId;
        this.schoolName = schoolName;
        this.location = location;
    }
}
