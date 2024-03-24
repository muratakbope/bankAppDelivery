package kz.singularity.bankAppDelivery.repository;

import kz.singularity.bankAppDelivery.model.Transaction;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TransactionRepository extends CrudRepository<Transaction, String> {
    List<Transaction> findAllByAccountId(String accountId);


}
