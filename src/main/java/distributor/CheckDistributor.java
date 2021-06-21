package distributor;

import distributor.base.BaseDistributor;
import file.FileUtils;
import model.authorization.User;
import model.card.Card;
import model.gateway.Gateway;
import model.merchant.Merchant;
import model.receive.DefaultReceiveModel;
import model.transaction.Transaction;
import model.transaction.TransactionState;
import response.CheckResponse;
import service.card.CardService;
import service.gateway.GatewayService;
import service.merchant.MerchantService;
import service.transaction.TransactionService;

import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class CheckDistributor implements BaseDistributor {

    public static void check(
            DefaultReceiveModel defaultReceiveModel,
            MerchantService merchantService,
            GatewayService gatewayService,
            TransactionService transactionService,
            CardService cardService,
            User user
    ) throws ParseException {


        Merchant merchant = merchantService.getMerchant(defaultReceiveModel.getServiceId());
        Gateway gateway = gatewayService.getGateway(merchant);

        Transaction transaction = new Transaction();
        transaction.setId();
        transaction.setCreatedDate(new Date());
        transaction.setTransactionAccount(defaultReceiveModel.getClientAccount());
        transaction.setTransactionAmount(defaultReceiveModel.getAmount());

        transaction.getAmountCurrency(gateway);

        HashMap cards = cardService.getAvailableCards(user, defaultReceiveModel.getAmount());

        Boolean transactionError = false;
        if (merchant == null || gateway == null)
            transactionError = true;

        if (merchant.getInActive())
            transactionError = true;

        if (cards.size() == 0)
            transactionError = true;

        if (merchant.getMinAmount().compareTo(defaultReceiveModel.getAmount()) <= 0 &&
                merchant.getMaxAmount().compareTo(defaultReceiveModel.getAmount()) >= 0)
            transactionError = true;
        transaction.setStatedId(TransactionState.CREATED.getValue());
        if (!defaultReceiveModel.isFull() && transactionError) {
            transaction.setStatedId(TransactionState.CHECK_ERROR.getValue());
            transaction.setTransactionDate(new Date());
        }
        else{

            transaction.setGateway(gateway);
            transaction.setMerchant(merchant);

            if (gateway.getBeeline()){
                if ((!defaultReceiveModel.getClientAccount().startsWith("90") ||
                        !defaultReceiveModel.getClientAccount().startsWith("91")) &&
                        defaultReceiveModel.getClientAccount().length() != 9
                )
                    transactionError = true;

            }else if (gateway.getQiwi()){

            }else if (gateway.getUcell()){
                if ((!defaultReceiveModel.getClientAccount().startsWith("94") ||
                        !defaultReceiveModel.getClientAccount().startsWith("93")) &&
                        defaultReceiveModel.getClientAccount().length() != 9
                )
                    transactionError = true;
            }

            FileUtils.save(transaction);
            CheckResponse checkResponse = new CheckResponse();
            checkResponse.checkResponse(transaction, transactionError);

            transactionService.add(transaction);

        }

    }

}
