package kz.singularity.bankAppRepository.repository;

import kz.singularity.bankAppRepository.model.Transaction;
import kz.singularity.bankAppRepository.model.TransactionType;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TransactionRepository extends CrudRepository<Transaction, String> {
    List<Transaction> findAllByAccountId(String accountId);


}
