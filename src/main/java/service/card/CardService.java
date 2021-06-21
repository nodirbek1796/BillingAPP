package service.card;

import file.FileUtils;
import front.CardFront;
import model.authorization.User;
import model.card.Card;
import service.base.BaseService;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class CardService extends BaseService {

    ArrayList<Card> cards = new ArrayList<>();

    @Override
    public boolean add(Object object, Object object1) {
        Card newCard = (Card) object;
        User currentUser = (User) object1;
        Card oldCard = findCard(newCard);
        boolean ans = false;
        if (oldCard != null) {
            if (addNewUserToCard(oldCard, currentUser))
                ans = true;
        }
        else {
            newCard.getUserIds()[0] = currentUser.getId();
            FileUtils.save(newCard);
            ans = true;
        }

        return ans;
    }

    @Override
    public boolean add(Object object) {
        return false;
    }

    @Override
    public boolean edit(Object object) {
        return false;
    }

    @Override
    public boolean delete(Object object) {
        return false;
    }

    @Override
    public void list() {

    }

    @Override
    public void list(Object object) {
       User currentUser = (User) object;
        for (Card card : this.cards)
            if (card != null)
                for (UUID userId : card.getUserIds())
                    if (userId != null)
                        if (userId.equals(currentUser.getId())){
                            System.out.println("==============================");
                            System.out.println("card number: " + card.getCardNumber());
                            System.out.println("card balance: " + card.getBalance());
                            System.out.println("card name: " + card.getName());
                            System.out.println("==============================");
                        }
    }



    public Card findCard(Card newCard) {
        Card oldCard = null;
        for (Card card : this.cards)
            if (card != null)
                if (card.getCardNumber().equals(newCard.getCardNumber()))
                    oldCard = card;
        return oldCard;
    }

    public Card findCard(UUID cardId) {
        Card oldCard = null;
        for (Card card : this.cards)
            if (card != null)
                if (cardId == card.getId())
                    oldCard = card;
        return oldCard;
    }

    public boolean addNewUserToCard(
            Card oldCard,
            User user
    ){
        boolean ans = false;
        if (!isAvailableUser(user, oldCard)) {
            String smsCode = CardFront.confirmSmsCode();
            if (oldCard.getPassword().equals(smsCode))
                ans = addUserIdToCard(user, oldCard);
        }
        return ans;
    }


    private boolean isAvailableUser(
            User user,
            Card oldCard
    ) {
        boolean ans = false;
        for (UUID userId : oldCard.getUserIds()) {
            if (userId == user.getId()) {
                ans = true;
                break;
            }
        }
        return ans;
    }

    private boolean addUserIdToCard(
            User newUser,
            Card oldCard
    ){
        boolean ans = false;
        for (int i = 0; i < oldCard.getUserIds().length && !ans; i++) {
            if (oldCard.getUserIds()[i] == null) {
                oldCard.getUserIds()[i] = newUser.getId();
                ans = true;
            }
        }

        return ans;
    }

    public HashMap getAvailableCards(
            User user,
            BigDecimal amount
    ){
        AtomicInteger helper = new AtomicInteger();
        Map<Integer, UUID> cards = new HashMap<>();
        this.cards.forEach((card)->{
            Arrays.stream(card.getUserIds()).forEach((userId)->{
                if (userId != null)
                if (userId.equals(user.getId()))
                    if (card.getBalance().compareTo(amount) >= 0){
                        System.out.println("=============="+ helper.incrementAndGet() +"================");
                        System.out.println("card number: " + card.getCardNumber());
                        System.out.println("card balance: " + card.getBalance());
                        System.out.println("==============================");
                        cards.put(helper.get(), card.getId());
                    }
            });
        });
        return (HashMap) cards;
    }

}
