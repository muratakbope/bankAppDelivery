package kz.singularity.bankAppDelivery.model;

import kz.singularity.bankAppDelivery.repository.TransactionRepository;
import kz.singularity.bankAppDelivery.service.AccountDepositService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class TransactionDeposit {
    private AccountDepositService accountDepositService;
    private final TransactionRepository transactionRepository;

    void execute(Account account, double amount) {
        accountDepositService.deposit(amount, account);
        transactionRepository.save(new Transaction(account.getAccountId(),
                TransactionType.DEPOSIT, amount, account.getBalance()));
    }
}
