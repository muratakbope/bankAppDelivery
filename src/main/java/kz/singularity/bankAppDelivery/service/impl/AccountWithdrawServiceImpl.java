package kz.singularity.bankAppDelivery.service.impl;

import kz.singularity.bankAppDelivery.model.AccountWithdraw;
import kz.singularity.bankAppDelivery.repository.AccountRepository;
import kz.singularity.bankAppDelivery.service.AccountWithdrawService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AccountWithdrawServiceImpl implements AccountWithdrawService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountWithdrawServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void withdraw(double amount, AccountWithdraw accountWithdraw) {
        double balanceAfterWithdraw = accountWithdraw.getBalance() - amount;
            accountWithdraw.setBalance(balanceAfterWithdraw);
            accountRepository.save(accountWithdraw);
    }
}
