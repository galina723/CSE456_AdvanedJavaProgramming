package org.example.data.paymentMethod;

public class EwalletPayment implements PaymentMethod {
    @Override
    public void makePayment(double amount) {
        System.out.println("Processing eWallet Payment of $" + amount);
    }
}
