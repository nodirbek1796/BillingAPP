import front.CardFront;
import front.DefaultCheckReceiveFront;
import front.DefaultPayReceiveFront;
import front.UserFront;
import model.authorization.User;
import service.authorization.UserService;
import service.card.CardService;
import service.gateway.GatewayService;
import service.merchant.MerchantService;
import service.transaction.TransactionService;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.util.Random;
import java.util.Scanner;

public class Main implements Action{

    public static void main(String[] args) throws ParseException {
        BigDecimal bigDecimal = BigDecimal.valueOf(58.884498).setScale(3,RoundingMode.HALF_DOWN);
        Scanner scanner = new Scanner(System.in);
        UserService userService = new UserService();
        CardService cardService = new CardService();
        TransactionService transactionService = new TransactionService();
        GatewayService gatewayService = new GatewayService();
        MerchantService merchantService = new MerchantService();
        gatewayService.helper();
        merchantService.helper();


        int stepCode = 1;
        while (stepCode != 0) {
            System.out.println(userAction);
            stepCode = scanner.nextInt();
            switch (stepCode) {
                case 1:
                    UserFront.addUser(userService);
                    break;
                case 2:
                    User user = UserFront.signIn(userService);
                    if(user != null)
                        addCard(
                                user,
                                cardService,
                                gatewayService,
                                merchantService,
                                transactionService
                        );
                    else
                        System.out.println("phone number or password incorrect");
                    break;
                case 3:
                    userService.list();
                    break;
            }
        }

    }

    public static void addCard(
            User user,
            CardService cardService,
            GatewayService gatewayService,
            MerchantService merchantService,
            TransactionService transactionService
    ) throws ParseException {
        Scanner scanner = new Scanner(System.in);

        int stepCode = 1;
        while (stepCode != 0) {
            System.out.println(cardAction);
            stepCode = scanner.nextInt();
            switch (stepCode) {
                case 1:
                    CardFront.addCard(cardService, user);
                    break;
                case 3:
                    cardService.list(user);
                    break;
                case 4: paymentCheck(
                        gatewayService,
                        merchantService,
                        transactionService,
                        cardService,
                        user
                );
                    break;
                case 5:
                     paymentPay(
                            transactionService,
                            cardService,
                            user
                    );
                    break;
                case 6:
                    transactionService.list();
                    break;
            }
        }

    }

    public static void paymentCheck(
            GatewayService gatewayService,
            MerchantService merchantService,
            TransactionService transactionService,
            CardService cardService,
            User user
    ) throws ParseException {
        DefaultCheckReceiveFront.addTransaction(
                merchantService,
                gatewayService,
                transactionService,
                cardService,
                user
        );
    }

    public static void paymentPay(
            TransactionService transactionService,
            CardService cardService,
            User user
    ) throws ParseException {
        DefaultPayReceiveFront.addTransaction(
                transactionService,
                cardService,
                user
        );
    }




}
