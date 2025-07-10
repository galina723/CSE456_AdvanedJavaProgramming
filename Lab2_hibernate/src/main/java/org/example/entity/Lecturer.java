package org.example.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Lecturers")
public class Lecturer {

    @Id
    @Column(name = "ID", columnDefinition = "CHAR(10)")
    private String id;

    @Column(name = "Name", nullable = false, columnDefinition = "NVARCHAR(50)")
    private String name;

    @Column(name = "Year of Birth", nullable = false)
    private int yearOfBirth;

    @Column(name = "Salary", nullable = false)
    private double salary;

}
