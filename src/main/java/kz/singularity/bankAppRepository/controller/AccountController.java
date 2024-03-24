package kz.singularity.bankAppRepository.controller;

import kz.singularity.bankAppRepository.model.*;
import kz.singularity.bankAppRepository.repository.AccountRepository;
import kz.singularity.bankAppRepository.repository.TransactionRepository;
import kz.singularity.bankAppRepository.service.AccountDepositService;
import kz.singularity.bankAppRepository.service.AccountListingService;
import kz.singularity.bankAppRepository.service.impl.AccountCreationServiceImpl;
import kz.singularity.bankAppRepository.service.impl.AccountDepositServiceImpl;
import kz.singularity.bankAppRepository.service.impl.AccountListingServiceImpl;
import kz.singularity.bankAppRepository.service.impl.AccountWithdrawServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    @Autowired
    AccountCreationServiceImpl creationService;
    @Autowired
    AccountListingServiceImpl listingService;
    @Autowired
    AccountDepositServiceImpl depositService;
    @Autowired
    AccountWithdrawServiceImpl withdrawService;
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    BankCore bankCore;


    @GetMapping()
    ResponseEntity<List<Account>> getAccounts(String clientId) {
        return new ResponseEntity<>(listingService.getClientAccounts(clientId), HttpStatus.OK);
    }

    @GetMapping("/{account_id}")
    ResponseEntity<Object> getAccountById(@PathVariable String account_id)  {
            Optional<Account> account = accountRepository.findById(account_id);
            if (account.isEmpty()) {
                return new ResponseEntity<>("No account found with accountId " + account_id, HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(account, HttpStatus.OK);
        }

    @PostMapping()
    ResponseEntity<String> createAccount(@RequestParam AccountType accountType) {
        bankCore.createNewAccount(accountType, "1");
        return new ResponseEntity<>("Bank account created successfully!", HttpStatus.CREATED);
    }

    @DeleteMapping("/{account_id}")
    ResponseEntity<String> deleteAccountById(@PathVariable String account_id) {
        if (accountRepository.findById(account_id).isEmpty()) {
            return new ResponseEntity<>("No account found with accountId " +
                    account_id, HttpStatus.NOT_FOUND);
        }
        accountRepository.deleteById(account_id);
        return new ResponseEntity<>("Account " + account_id + " deleted", HttpStatus.OK);
    }

    @PostMapping("/{account_id}/deposit")
    ResponseEntity<String> depositMoney(@PathVariable String account_id, @RequestParam double deposit) {
        Optional<Account> account = accountRepository.findById(account_id);
        if (account.isEmpty()) {
            return new ResponseEntity<>("No account found with accountId " +
                    account_id, HttpStatus.NOT_FOUND);
        } else if (deposit <= 0) {
            return new ResponseEntity<>("Please provide a positive amount for the deposit.",
                    HttpStatus.BAD_REQUEST);
        }
        depositService.deposit(deposit, account.get());
        transactionRepository.save(new Transaction(account_id, TransactionType.DEPOSIT, deposit,
                (account.get()).getBalance()));
        return new ResponseEntity<>(deposit + " transferred to the account " + account_id,
                    HttpStatus.OK);
    }

    @PostMapping("/{account_id}/withdraw")
    ResponseEntity<String> withdrawMoney(@PathVariable String account_id, @RequestParam double withdraw) {
        Optional<Account> account = accountRepository.findById(account_id);
        if (account.isEmpty()) {
            return new ResponseEntity<>("No account found with accountId " +
                    account_id, HttpStatus.NOT_FOUND);
        } else if (account.get().getAccountType() == AccountType.FIXED) {
            return new ResponseEntity<>("This is a FIXED account. Money transfers are not permitted!",
                    HttpStatus.NOT_FOUND);
        } else {
            if (withdraw <= 0) {
                return new ResponseEntity<>("Please provide a positive amount for the deposit.",HttpStatus.NOT_FOUND);
            } else if (withdraw > account.get().getBalance()) {
                return new ResponseEntity<>("Sorry, you have insufficient funds to withdraw the request amount. "
                        + "Your account balance is " + String.format("%.2f", account.get().getBalance()) + "$",
                        HttpStatus.BAD_REQUEST);
            }
        }
        withdrawService.withdraw(withdraw, (AccountWithdraw) account.get());
        transactionRepository.save(new Transaction(account_id, TransactionType.WITHDRAW, withdraw,
                ((AccountWithdraw) account.get()).getBalance()));
        return new ResponseEntity<>(withdraw + " transferred from the account " + account_id, HttpStatus.OK);
    }

    @GetMapping("/{account_id}/transactions")

    ResponseEntity<Object> getAllTransactions(@PathVariable String account_id) {
        if (accountRepository.findById(account_id).isEmpty()) {
            return new ResponseEntity<>("No account found with accountId " +
                    account_id, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(transactionRepository.findAllByAccountId(account_id), HttpStatus.OK);
    }

}

