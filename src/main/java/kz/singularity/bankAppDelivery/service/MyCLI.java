package kz.singularity.bankAppDelivery.service;

import kz.singularity.bankAppDelivery.model.AccountType;
import kz.singularity.bankAppDelivery.model.CLIUI;
import lombok.*;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.Scanner;
@Getter
@Component
@Data
@Primary

public class MyCLI implements CLIUI {
    Scanner scanner;

    public MyCLI() {
        this.scanner = new Scanner(System.in);
    }

    public MyCLI(Scanner scanner) {
        this.scanner = scanner;
    }
    public double requestClientAmount(){
        return getScanner().nextDouble();
    }

    public String requestClientAccountNumber() {

        return String.valueOf(scanner.nextLine());
    }

    @Override
    public AccountType requestAccountType() {
        return AccountType.valueOf(scanner.nextLine());
    }
}
