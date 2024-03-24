package kz.singularity.bankAppDelivery.service;

import kz.singularity.bankAppDelivery.model.Account;
import kz.singularity.bankAppDelivery.model.AccountType;
import kz.singularity.bankAppDelivery.model.AccountWithdraw;

import java.util.List;

public interface AccountListingService {
    Account getClientAccount(String clientId, String accountId);
    AccountWithdraw getClientWithdrawAccount(String clientId, String accountId);
    List<Account> getClientAccounts(String clientId);
    List<Account> getClientAccountsByType(String clientId, AccountType accountType);

}
