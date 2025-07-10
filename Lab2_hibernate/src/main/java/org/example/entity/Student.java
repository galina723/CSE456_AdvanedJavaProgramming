package org.example.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Students") //nếu muốn đặt tên bảng khác tên class
@Data //lombok để generate constructor, getter, setter,..
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id //đánh dấu cột khóa chính
    @Column(name = "ID", columnDefinition = "CHAR(10)")
    private String id;

    @Column(name = "Name", columnDefinition = "NVARCHAR(50)", nullable = false)
    private String name;

    @Column(name = "Year of Birth", nullable = false)
    private int yob;

    @Column(name = "Gpa")
    private double gpa;

}
