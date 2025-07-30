package org.example.data.entity;

public class Transaction {
    private static int countId = 1;
    private int id;
    private double amount;
    private String paymentType;
    private String status;

    public Transaction() {
        this.id = countId++;
        this.amount = amount;
        this.paymentType = paymentType;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id='" + id + '\'' +
                ", amount=" + amount +
                ", paymentType='" + paymentType + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
