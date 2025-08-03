package org.example.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Table (name = "customer")
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;
    @Column(name = "FullName", nullable = false)
    private String fullName;
    @Column(name = "Email", nullable = false)
    private String email;
    @Column(name = "PhoneNumber")
    private String phoneNumber;
    @Column(name = "Address")
    private String address;
    @OneToMany(fetch =  FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "customer")
    private List<Invoice> invoices = new ArrayList<>();

    public Customer(String fullName, String email, String phoneNumber, String address) {
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public void addInvoice(Invoice invoice){
        invoices.add(invoice);
        invoice.setCustomer(this);
    }
}
