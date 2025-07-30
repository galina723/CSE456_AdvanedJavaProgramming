package org.example.presentation;

import org.example.data.entity.Transaction;
import org.example.service.PaymentService;
import org.example.data.paymentMethod.BankTransferPayment;
import org.example.data.paymentMethod.CardPayment;
import org.example.data.paymentMethod.EwalletPayment;

public class Main {

    public static void main(String[] args) {

        //BankPayment
        BankTransferPayment bf = new BankTransferPayment();
        PaymentService ps = new PaymentService(bf);
        String from = "Anna";
        double amount = 500000;
        Transaction transaction = new Transaction();
        transaction.setAmount(amount);
        transaction.setPaymentType(bf.getClass().getSimpleName());
        transaction.setStatus("SUCCESS");
        ps.addTransaction(transaction, from, amount);

        //CardPayment
        CardPayment cp = new CardPayment();
        ps.settPaymentType(cp);
        transaction = new Transaction();
        transaction.setAmount(amount);
        transaction.setPaymentType(cp.getClass().getSimpleName());
        transaction.setStatus("SUCCESS");
        ps.addTransaction(transaction, from, amount);

        //EwalletPayment
        EwalletPayment ew = new EwalletPayment();
        ps.settPaymentType(ew);
        transaction = new Transaction();
        transaction.setAmount(amount);
        transaction.setPaymentType(ew.getClass().getSimpleName());
        transaction.setStatus("SUCCESS");
        ps.addTransaction(transaction, from, amount);
    }
}
