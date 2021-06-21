package front;

import model.authorization.User;
import model.base.BaseModel;
import model.card.Card;
import model.card.CardType;
import service.card.CardService;

import java.math.BigDecimal;
import java.util.Random;
import java.util.Scanner;

public class CardFront extends BaseResponse {

    public static String confirmSmsCode(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter sms code");
        return scanner.nextLine();
    }

    public static void addCard(CardService cardService , User user) {
        Scanner scanner = new Scanner(System.in);

        Card card = new Card();
        Random random = new Random();

        card.setId();
        System.out.println("enter Card number: ");
        card.setCardNumber(scanner.nextLine());

        System.out.println("enter expiry day: ");
        card.setExpiryDate(scanner.nextLine());

        scanner = new Scanner(System.in);
        System.out.println("enter card type: ");
        card.setCardType(CardType.valueOf(scanner.nextLine().toUpperCase()));

        scanner = new Scanner(System.in);
        System.out.println("enter name: ");
        card.setName(scanner.nextLine());

        scanner = new Scanner(System.in);
        System.out.println("enter password: ");
        card.setPassword(scanner.nextLine());

        card.setBalance(getBalance());
        System.out.println(cardService.add(card,user));

    }

    private static BigDecimal getBalance(){
        return BigDecimal.valueOf(Math.random() * 10_000_000L).setScale(2,BigDecimal.ROUND_HALF_DOWN);
    }


}
