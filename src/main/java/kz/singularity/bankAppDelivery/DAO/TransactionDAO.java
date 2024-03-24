package kz.singularity.bankAppDelivery.DAO;

import kz.singularity.bankAppDelivery.model.Transaction;

import java.util.List;

public interface TransactionDAO {
    List<Transaction> getTransactions();
    void addTransaction(Transaction transaction);
}
