package distributor;

import distributor.base.BaseDistributor;
import model.authorization.User;
import model.card.Card;
import model.receive.DefaultPayReceiveModel;
import model.transaction.Transaction;
import model.transaction.TransactionState;
import response.BasePayResponse;
import response.PayResponse;
import service.authorization.UserService;
import service.card.CardService;
import service.transaction.TransactionService;

import java.util.HashMap;
import java.util.Scanner;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public class PayDistributor implements BaseDistributor {

    public static void pay(
            DefaultPayReceiveModel defaultPayReceiveModel,
            CardService cardService,
            TransactionService transactionService,
            User user
    ){
        Scanner scanner = new Scanner(System.in);
        boolean transactionError = false;
        long currentTimeMillis = System.currentTimeMillis();
        Transaction transaction = transactionService.getTransactionById(defaultPayReceiveModel.getTransactionId());
        long checkTime  = currentTimeMillis - transaction.getTransactionDate().getTime();

        if (transaction.getStatedId() != TransactionState.CHECKED.getValue())
            transactionError = true;
        if (checkTime / 1_000 / 60 > 2)
            transactionError = true;


        if (!transactionError){
            transaction.setStatedId(TransactionState.PAYING.getValue());
            HashMap cards = cardService.getAvailableCards(user, transaction.getTransactionAmount());
            System.out.println("=== choose card number === ");
            if (cards.size() != 0){
                int index = scanner.nextInt();
                Object cardId = cards.get(index);
                Card card = cardService.findCard((UUID) cardId);
                card.setBalance(card.getBalance().subtract(transaction.getTransactionAmount()));
                transaction.setStatedId(TransactionState.SUCCESS.getValue());
            }else
                transactionError = true;

        }

        PayResponse payResponse = new PayResponse();
        payResponse.payResponse(transaction, transactionError);

    }
}
