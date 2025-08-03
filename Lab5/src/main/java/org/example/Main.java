package org.example;

import org.example.config.AppConfig;
import org.example.entity.Customer;
import org.example.entity.Invoice;
import org.example.entity.Product;
import org.example.service.CustomerService;
import org.example.service.InvoiceService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDate;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);

        CustomerService cs = appContext.getBean(CustomerService.class);
        InvoiceService is = appContext.getBean(InvoiceService.class);

        Customer customer1 = new Customer("Anna", "anna@example.com", "0987654321", "HN");
        Customer customer2 = new Customer("Lily", "lily@gmail.com", "0123456789", "HCM");
        cs.createCustomer(customer1);
        cs.createCustomer(customer2);

        Product product1 = new Product("Laptop", 1200.00);
        Product product2 = new Product("Smartphone", 800.00);
        Product product3 = new Product("Tablet", 500.20);

        List<Product> product = new ArrayList<>();
        product.add(product1);
        product.add(product2);
        product.add(product3);

        Invoice invoice = new Invoice(customer1, product);
        is.createInvoice(invoice, "InvoiceProduct", LocalDate.now());
    }
}