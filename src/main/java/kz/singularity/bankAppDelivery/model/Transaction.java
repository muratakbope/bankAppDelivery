package kz.singularity.bankAppDelivery.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Transaction {
    @Id
    private String accountId;
    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;
    private double balance;
    private double balanceAfterTransaction;


}
