package service.transaction;

import distributor.base.BaseDistributor;
import model.transaction.Transaction;
import service.base.BaseService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class TransactionService extends BaseService implements BaseDistributor {

    List<Transaction> transactions = new ArrayList<>();


    @Override
    public boolean add(Object object, Object object1) {
        return false;
    }

    @Override
    public boolean add(Object object) {
        Transaction transaction = (Transaction) object;
        transactions.add(transaction);

        return true;
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
        System.out.println("id \t\t account \t\t amount \t\t amount_in_currency \t\t merchant \t\t state \t\t gateway \t\t currency \t\t created_date \t\t updated_date");
        transactions.forEach((transaction -> {
            System.out.println("----------------------------------------------------------------------------------");
            System.out.println(transaction.getId() + "\t" + transaction.getTransactionAccount() +
                    "\t" + transaction.getTransactionAmount() + "\t" + transaction.getTransactionAmountCurrency() +
                    "\t" + transaction.getMerchant().getName() + "\t" + transaction.getState() + "\t" + transaction.getGateway().getName() +
                    "\t" + transaction.getGateway().getCurrency().getCode() + "\t" + simpleDateFormat.format(transaction.getCreatedDate()) + "\t"
                    + simpleDateFormat.format(transaction.getTransactionDate())
            );
            System.out.println("----------------------------------------------------------------------------------");
        }));
    }

    @Override
    public void list(Object object) {

    }

    public Transaction getTransactionById(UUID transactionId) {
        List<Transaction> transactionList = this.transactions.stream().filter((transaction -> transaction.getId().equals(transactionId))).collect(Collectors.toList());
        return transactionList.get(0);
    }
}
