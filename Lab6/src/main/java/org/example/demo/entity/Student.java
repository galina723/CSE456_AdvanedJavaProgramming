package org.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "student")
/*
Nếu talbe có key tự động tăng thì phải thêm 1 constructor đầy đủ
tham số, nhưng bỏ tham số key đi
 */
public class Student {
    //Nếu id là key tự tăng thì không có trong constructor full tham số.
    //và nên dùng kiểu wrapper class Long
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int yob;
    private double gpa;
}
