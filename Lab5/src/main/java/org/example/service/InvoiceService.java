package org.example.service;

import org.example.context.PdfGenerator;
import org.example.entity.Invoice;
import org.example.entity.Product;
import org.example.repository.InvoiceRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class InvoiceService {
    public PdfGenerator pdf;
    public InvoiceService(PdfGenerator pdf){
        this.pdf = pdf;
    }
    public void createInvoice(Invoice inv, String pdfName, LocalDate date){
        InvoiceRepo.addInvoice(inv);
        System.out.println("#" + inv.getInvoiceId());
        System.out.println("Customer: " + inv.getCustomer().getFullName());
        System.out.println("Products: ");
        for(Product p : inv.getProducts()){
            System.out.println(p.getProductName() + " has price $" + p.getPrice());
        }
        System.out.println("Total: $" + inv.getTotal());
        String filename = "Invoice_" + pdfName + "_" + date + ".pdf";
        pdf.generatePdf(filename);
    }
    public void removeInvoice(Invoice inv){
        InvoiceRepo.removeInvoice(inv.getInvoiceId());
    }
}