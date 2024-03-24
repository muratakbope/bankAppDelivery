package kz.singularity.bankAppDelivery.model;

import jakarta.persistence.Entity;
import lombok.*;


@AllArgsConstructor
@Entity

public class AccountWithdraw extends Account{

    public AccountWithdraw(AccountType accountType, String id, String clientId, double balance,
                           boolean withdrawAllowed) {

        super(accountType, id, clientId, balance, withdrawAllowed);
    }
}
