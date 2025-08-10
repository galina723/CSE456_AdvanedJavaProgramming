package org.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "major")
/*
Nếu table có key tự động tăng thì phải thêm 1 constructor đầy đủ
tham số, nhưng bỏ tham số key đi
 */
public class Major {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String code;
    private String name;
}
