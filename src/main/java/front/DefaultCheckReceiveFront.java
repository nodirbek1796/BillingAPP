package front;

import distributor.CheckDistributor;
import model.authorization.User;
import model.receive.DefaultReceiveModel;
import service.card.CardService;
import service.gateway.GatewayService;
import service.merchant.MerchantService;
import service.transaction.TransactionService;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Scanner;

public class DefaultCheckReceiveFront {

    public static void addTransaction(
            MerchantService merchantService,
            GatewayService gatewayService,
            TransactionService transactionService,
            CardService cardService,
            User user
    ) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("service id: ");
        int serviceId = scanner.nextInt();
        System.out.print("account: ");
        scanner = new Scanner(System.in);
        String account = scanner.nextLine();
        System.out.print("amount: ");
        scanner = new Scanner(System.in);
        BigDecimal amount = scanner.nextBigDecimal();
        DefaultReceiveModel defaultReceiveModel = new DefaultReceiveModel(
                account,
                serviceId,
                amount
        );

        CheckDistributor.check(
                defaultReceiveModel,
                merchantService,
                gatewayService,
                transactionService,
                cardService,
                user
        );
    }
}
