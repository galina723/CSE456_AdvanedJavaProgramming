package org.example.service;

import org.example.data.entity.Transaction;
import org.example.data.repository.TransactionRepo;
import org.example.data.paymentMethod.PaymentMethod;

public class PaymentService {

    private PaymentMethod paymentMethod;
    private TransactionRepo transactionRepo;

    public PaymentService(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
        this.transactionRepo = new TransactionRepo();
    }

    public void settPaymentType(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void addTransaction(Transaction transaction, String from, double amount) {
        paymentMethod.makePayment(amount);
        transaction.setAmount(amount);
        transaction.setPaymentType(paymentMethod.getClass().getSimpleName());
        transaction.setStatus("SUCCESS");
        transactionRepo.saveTransaction(transaction);
        System.out.println("Transaction processed: " + transaction);
    }
}
