package kz.singularity.bankAppDelivery;

import kz.singularity.bankAppDelivery.model.AccountBasicCLI;
import kz.singularity.bankAppDelivery.model.TransactionWithdrawCLI;
import kz.singularity.bankAppDelivery.service.MyCLI;
import kz.singularity.bankAppDelivery.model.TransactionDepositCLI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class bankAppDelivery implements CommandLineRunner {
    @Autowired
    private ApplicationContext context;

    public static void main(String[] args) {

        SpringApplication.run(bankAppDelivery.class);
    }

    @Override
    public void run(String... arg0) throws Exception {
        boolean running = true;
        String clientId = "1";

        MyCLI myCLI = context.getBean(MyCLI.class);
        AccountBasicCLI accountBasicCLI = context.getBean(AccountBasicCLI.class);
        TransactionDepositCLI transactionDepositCLI = context.getBean(TransactionDepositCLI.class);
        TransactionWithdrawCLI transactionWithdrawCLI = context.getBean(TransactionWithdrawCLI.class);

        String helpMessage = "1 - show accounts\n2 - create account\n3 " +
                "- deposit\n4 - withdraw\n5 - transfer\n6 - this message\n7 - exit\n";
        System.out.printf("Welcome to CLI bank service\n");
        System.out.printf("Enter operation number: \n");
        System.out.printf(helpMessage);
        while(running){
            try {
                switch (myCLI.getScanner().nextLine()) {

                    case "1" -> accountBasicCLI.getAccounts(clientId);
                    case "2" -> {
                        System.out.println("Choose account type: [ CHECKING, SAVING, FIXED ]");
                        accountBasicCLI.createAccountRequest(myCLI.requestAccountType(), clientId);
                    }
                    case "3" -> transactionDepositCLI.depositMoney(clientId);
                    case "4" -> transactionWithdrawCLI.withdrawMoney(clientId);
                    case "6" -> System.out.printf(helpMessage);
                    case "7" -> {
                        System.out.printf("Application Closed\n");
                        running = false;
                    }
                    default -> System.out.printf("Command not recognized!\n");
                }
            } catch (Exception e) {
                System.out.println("Wrong input " + e.getMessage());
            }
        }
        myCLI.getScanner().close();
    }
}