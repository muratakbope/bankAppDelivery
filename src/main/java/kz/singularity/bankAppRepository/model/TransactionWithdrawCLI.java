package kz.singularity.bankAppRepository.model;

import kz.singularity.bankAppRepository.service.AccountListingService;
import kz.singularity.bankAppRepository.service.MyCLI;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class TransactionWithdrawCLI implements WithdrawDepositOperationCLIUI{

    private TransactionWithdraw transactionWithdraw;
    private WithdrawDepositOperationCLIUI withdrawDepositOperationCLIUI;
    private AccountListingService accountListingService;
    private MyCLI myCLI;


    public void withdrawMoney(String clientId) {
        System.out.println("Type account ID");
        String accountId = withdrawDepositOperationCLIUI.requestClientAccountNumber();
        Account account = accountListingService.getClientAccount(clientId, accountId);
        if (account.getAccountId().equals(accountId) && account.isWithdrawAllowed()) {
                AccountWithdraw accountWithdraw = accountListingService.getClientWithdrawAccount(clientId, accountId);
                System.out.println("Type amount of money");
                double amount = withdrawDepositOperationCLIUI.requestClientAmount();
                if (accountWithdraw.getBalance() - amount >= 0) {
                    transactionWithdraw.execute(accountWithdraw, amount);
                    System.out.println(String.format("%,.2f", amount) + "$ transferred from "
                            + account.getAccountId() + " account");
                    myCLI.getScanner().nextLine();
                } else {
                    System.out.println("Sorry, you have insufficient funds to withdraw the request amount. " +
                            "Your account balance is " + String.format("%.2f", accountWithdraw.getBalance()) + "$");
                    myCLI.getScanner().nextLine();
                }
            } else {
                System.out.println("This is a FIXED account. Money transfers are not permitted!");
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
