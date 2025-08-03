package org.example.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Table(name = "product")
@Entity
@NoArgsConstructor
@ToString(exclude = "customer")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;
    @Column(name = "ProductName", nullable = false)
    private String productName;
    @Column(name = "Price", nullable = false)
    private double price;

    public Product(String productName, double price) {
        this.productName = productName;
        this.price = price;
    }
}
