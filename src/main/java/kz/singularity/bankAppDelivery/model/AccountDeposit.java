package kz.singularity.bankAppDelivery.model;

import jakarta.persistence.Entity;
import lombok.*;

@AllArgsConstructor
@Entity
public class AccountDeposit extends Account{
    public AccountDeposit(AccountType accountType, String id, String clientId, double balance,
                          boolean withdrawAllowed) {
        super(accountType, id, clientId, balance, withdrawAllowed);
        setWithdrawAllowed(false);
    }
}
