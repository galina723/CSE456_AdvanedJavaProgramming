package org.example.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Subjects")
public class Subject {

    @Id
    @Column(name = "ID", columnDefinition = "CHAR(10)")
    private String id;

    @Column(name = "Name", nullable = false, columnDefinition = "NVARCHAR(50)")
    private String name;

    @Column(name = "Description", nullable = false, columnDefinition = "NVARCHAR(255)")
    private String description;

    @Column(name = "Credit", nullable = false)
    private int credit;

    @Column(name = "StudyHour", nullable = false)
    private int studyHour;

}
