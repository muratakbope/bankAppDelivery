package kz.singularity.bankAppDelivery.service.impl;

import kz.singularity.bankAppDelivery.model.Account;
import kz.singularity.bankAppDelivery.model.AccountType;
import kz.singularity.bankAppDelivery.model.AccountWithdraw;
import kz.singularity.bankAppDelivery.repository.AccountRepository;
import kz.singularity.bankAppDelivery.service.AccountListingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountListingServiceImpl implements AccountListingService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountListingServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
    @Override
    public Account getClientAccount(String clientId, String accountId) {
        return accountRepository.getAccountByClientIdAndAccountId(clientId, accountId);
    }

    @Override
    public AccountWithdraw getClientWithdrawAccount(String clientId, String accountId) {
        return accountRepository.findAccountByClientIdAndAccountId(clientId, accountId);
    }

    @Override
    public List<Account> getClientAccounts(String clientId) {
        return accountRepository.findAll();
    }

    @Override
    public List<Account> getClientAccountsByType(String clientId, AccountType accountType) {
        return accountRepository.getAccountsByClientIdAndAccountType(clientId, accountType);
    }
}
