package org.example.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
//@Getter
//@Setter
@NoArgsConstructor
@AllArgsConstructor
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
    @ToString.Exclude
    private List<Major> majors =  new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "school")
    @ToString.Exclude
    private List<Student> students =  new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
        student.setSchool(this);
    }

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
