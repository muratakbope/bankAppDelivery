package kz.singularity.bankAppDelivery.model;

import jakarta.persistence.Entity;
import lombok.*;


@AllArgsConstructor
@Entity
public class SavingAccount extends AccountWithdraw{
    public SavingAccount(AccountType accountType, String id, String clientId, double balance,
                           boolean withdrawAllowed) {
        super(accountType, id, clientId, balance, withdrawAllowed);
    }
}
