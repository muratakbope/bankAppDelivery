package kz.singularity.bankAppDelivery.repository;

import kz.singularity.bankAppDelivery.model.Account;
import kz.singularity.bankAppDelivery.model.AccountType;
import kz.singularity.bankAppDelivery.model.AccountWithdraw;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends CrudRepository<Account, String> {
    List<Account> findAll();
    List<Account> getAccountsByClientIdAndAccountType(String clientId, AccountType accountType);
    AccountWithdraw findAccountByClientIdAndAccountId(String clientId, String accountId);
    Account getAccountByClientIdAndAccountId(String clientId, String accountId);
}
