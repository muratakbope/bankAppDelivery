package kz.singularity.bankAppDelivery.service;

import kz.singularity.bankAppDelivery.model.AccountWithdraw;

public interface AccountWithdrawService {
    void withdraw(double amount, AccountWithdraw accountWithdraw);
}
