package org.example.data.repository;

import org.example.data.entity.Transaction;

public class TransactionRepo {
    public void saveTransaction(Transaction transaction) {
        System.out.println("Transaction saved: " + transaction);
    }
}
