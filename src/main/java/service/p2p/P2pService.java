package service.p2p;

import model.card.Card;
import model.p2p.P2p;
import service.card.CardService;

import java.math.BigDecimal;

public class P2pService {

    public void p2p(
            P2p p2p,
            CardService cardService
    ){
        Card sourceCard = cardService.findCard(p2p.getSourceCardId());
        Card destinationCard = cardService.findCard(p2p.getDestinationCardId());

        if (sourceCard.getCardType().equals(destinationCard.getCardType()))
            p2p.setCommissionUp(0.0);
        else
            p2p.setCommissionUp(1.0);
    }

    public void ddd(
            Card sourceCard,
            Card destinationCard,
            P2p p2p
    ){

        BigDecimal commisionAmount = BigDecimal.valueOf(1).add(BigDecimal.valueOf(p2p.getCommissionUp()).divide(BigDecimal.valueOf(100)));
        BigDecimal balance = p2p.getTransferAmount().multiply(commisionAmount);
        sourceCard.setBalance(sourceCard.getBalance().subtract(balance));
        destinationCard.setBalance(destinationCard.getBalance().add(p2p.getTransferAmount()));

    }

}
