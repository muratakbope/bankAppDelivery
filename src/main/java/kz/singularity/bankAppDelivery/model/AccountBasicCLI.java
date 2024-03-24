package kz.singularity.bankAppDelivery.model;

import kz.singularity.bankAppDelivery.service.AccountListingService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@AllArgsConstructor
public class AccountBasicCLI implements CreateAccountOperationUI{

    private CreateAccountOperationUI createAccountOperationUI;
    private BankCore bankCore;
    private AccountListingService accountListing;


    public void createAccountRequest(AccountType accountType, String clientId) {
        bankCore.createNewAccount(accountType, clientId);
        System.out.println("Bank account created successfully!");
    }

    public void getAccounts(String clientId) {
        List<Account> accounts = accountListing.getClientAccounts(clientId);
        if (accounts.isEmpty()) {
            System.out.println(accounts);
        }
        for (Account account: accounts) {
            System.out.println(account);
        }
    }

    @Override
    public AccountType requestAccountType() {
        return null;
    }
}
