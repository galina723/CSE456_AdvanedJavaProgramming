package org.example.data.paymentMethod;

public class CardPayment implements PaymentMethod {
    @Override
    public void makePayment(double amount) {
        System.out.println("Processing Card Payment of $" + amount);
    }
}
