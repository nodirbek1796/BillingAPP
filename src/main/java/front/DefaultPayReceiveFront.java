package front;

import distributor.CheckDistributor;
import distributor.PayDistributor;
import model.authorization.User;
import model.receive.DefaultPayReceiveModel;
import model.receive.DefaultReceiveModel;
import service.card.CardService;
import service.gateway.GatewayService;
import service.merchant.MerchantService;
import service.transaction.TransactionService;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Scanner;
import java.util.UUID;

public class DefaultPayReceiveFront {

    public static void addTransaction(
            TransactionService transactionService,
            CardService cardService,
            User user
    ) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("transaction id: ");
        String transactionId = scanner.nextLine();
        DefaultPayReceiveModel defaultPayReceiveModel = new DefaultPayReceiveModel();
        defaultPayReceiveModel.setTransactionId(UUID.fromString(transactionId));

        PayDistributor.pay(
                defaultPayReceiveModel,
                cardService,
                transactionService,
                user
        );
    }
}
