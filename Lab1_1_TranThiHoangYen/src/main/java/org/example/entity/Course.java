package org.example.entity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor //phuong thuc khoi tao khong tham so
@AllArgsConstructor //phuong thuc khoi tao full tham so
@ToString //toString()
public class Course {
    private String idCourse;
    private String name;
    private int credits;
    private double hours;
}
