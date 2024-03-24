package kz.singularity.bankAppDelivery.model;

import kz.singularity.bankAppDelivery.service.AccountListingService;
import kz.singularity.bankAppDelivery.service.MyCLI;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class TransactionDepositCLI implements WithdrawDepositOperationCLIUI{
    private TransactionDeposit transactionDeposit;
    private WithdrawDepositOperationCLIUI withdrawDepositOperationCLIUI;
    private AccountListingService accountListingService;
    private MyCLI myCLI;


    public void depositMoney(String clientId) {
        System.out.println("Type account ID");
        String accountId = withdrawDepositOperationCLIUI.requestClientAccountNumber();
        Account account = accountListingService.getClientAccount(clientId, accountId);
        if (account.getAccountId().equals(accountId)) {
            System.out.println("Type amount of money");
            double amount = withdrawDepositOperationCLIUI.requestClientAmount();
            transactionDeposit.execute(account, amount);
            System.out.println(String.format("%,.2f", amount) + "$ transferred to "
                                                + account.getAccountId() + " account");
            myCLI.getScanner().nextLine();
            }
    }

    @Override
    public double requestClientAmount() {
        return 0;
    }

    @Override
    public String requestClientAccountNumber() {
        return null;
    }
}
