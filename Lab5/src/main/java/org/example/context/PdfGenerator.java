package org.example.context;

import org.springframework.stereotype.Component;

@Component
public class PdfGenerator {
    public void generatePdf(String filename){
        System.out.println("The file " + filename + " has been generated successfully.");
    }
}