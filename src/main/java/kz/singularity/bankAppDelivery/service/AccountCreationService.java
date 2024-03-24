package kz.singularity.bankAppDelivery.service;

import kz.singularity.bankAppDelivery.model.AccountType;

public interface AccountCreationService {
    void create(AccountType accountType, long bankId,
                String clientId, String accountId);

}
