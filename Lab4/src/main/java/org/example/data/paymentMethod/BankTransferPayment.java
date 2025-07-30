package org.example.data.paymentMethod;

public class BankTransferPayment implements PaymentMethod {
    @Override
    public void makePayment(double amount) {
        System.out.println("Processing Bank Transfer Payment of $" + amount);
    }
}
