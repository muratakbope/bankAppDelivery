package kz.singularity.bankAppRepository.model;

import kz.singularity.bankAppRepository.repository.TransactionRepository;
import kz.singularity.bankAppRepository.service.AccountWithdrawService;
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
