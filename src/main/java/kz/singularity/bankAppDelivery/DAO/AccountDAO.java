package kz.singularity.bankAppDelivery.DAO;

import kz.singularity.bankAppDelivery.model.Account;
import kz.singularity.bankAppDelivery.model.AccountType;
import kz.singularity.bankAppDelivery.model.AccountWithdraw;


import java.util.List;


public interface AccountDAO  {
    List<Account> getClientAccounts(String clientId);
    void createNewAccount(Account account);
    void updateAccount(Account account);
    List<Account> getClientAccountsByType(String clientId, AccountType accountType);
    AccountWithdraw getClientWithdrawAccount(String clientId, Long accountId);
    Account getClientAccount(String clientId, Long accountId);



}
