package kz.singularity.bankAppDelivery.service;

import kz.singularity.bankAppDelivery.model.Account;

public interface AccountDepositService {
    void deposit(double amount, Account account);
}
