package kz.singularity.bankAppDelivery.model;

import jakarta.persistence.*;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
public class Account {
    @Enumerated(EnumType.STRING)
    private AccountType accountType;
    @Id
    private String accountId;
    private String clientId;
    private double balance;
    private boolean withdrawAllowed;




    public String toString() {
        return "Account{" +
                "accountType=" + accountType +
                ", id='" + accountId + '\'' +
                ", clientID='" + clientId + '\'' +
                ", balance=" + balance +
                ", withdrawAllowed=" + withdrawAllowed +
                '}';
    }

}
