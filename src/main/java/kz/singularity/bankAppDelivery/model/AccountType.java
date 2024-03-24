package kz.singularity.bankAppDelivery.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum AccountType {
    CHECKING("CHECKING"),
    FIXED("FIXED"),
    SAVING("SAVING");
    String accountType;
}
