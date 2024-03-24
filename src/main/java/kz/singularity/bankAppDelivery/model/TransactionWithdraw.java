package kz.singularity.bankAppDelivery.model;

import kz.singularity.bankAppDelivery.repository.TransactionRepository;
import kz.singularity.bankAppDelivery.service.AccountWithdrawService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class TransactionWithdraw {
    private AccountWithdrawService accountWithdrawService;
    private final TransactionRepository transactionRepository;


    void execute(AccountWithdraw accountWithdraw, double amount) {
        accountWithdrawService.withdraw(amount, accountWithdraw);
        transactionRepository.save(new Transaction(accountWithdraw.getAccountId(),
                TransactionType.WITHDRAW, amount, accountWithdraw.getBalance()));
    }
}
