package kz.singularity.bankAppRepository.service.impl;

import kz.singularity.bankAppRepository.model.CheckingAccount;
import kz.singularity.bankAppRepository.model.FixedAccount;
import kz.singularity.bankAppRepository.repository.AccountRepository;
import kz.singularity.bankAppRepository.service.AccountCreationService;
import kz.singularity.bankAppRepository.model.AccountType;
import kz.singularity.bankAppRepository.model.SavingAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountCreationServiceImpl implements AccountCreationService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountCreationServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void create(AccountType accountType, long bankId, String clientId, String accountId) {

        String accountUIID = String.format("%03d%06d", 1, Integer.parseInt(accountId));

        switch (accountType) {
                case FIXED -> accountRepository.save(new FixedAccount(accountType,
                        accountUIID, clientId, 0.0, true));
                case SAVING -> accountRepository.save(new SavingAccount(accountType,
                        accountUIID, clientId, 0.0, true));
                case CHECKING -> accountRepository.save(new CheckingAccount(accountType,
                        accountUIID, clientId, 0.0, true));
                default -> System.out.println("Wrong input!");
            }
    }

}
