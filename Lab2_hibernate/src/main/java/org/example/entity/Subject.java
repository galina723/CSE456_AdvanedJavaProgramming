package org.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Data
@Getter
@Setter
@Table(name = "Subjects")
@AllArgsConstructor
@NoArgsConstructor
public class Subject {

    @Id
    @Column(name = "ID", columnDefinition = "CHAR(10)", nullable = false)
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
