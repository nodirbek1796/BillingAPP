package service.account;

import model.account.Account;
import model.gateway.Gateway;
import service.base.BaseService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class AccountService extends BaseService {

    List<Account> accounts = new ArrayList<>();


    @Override
    public boolean add(Object object, Object object1) {
        return false;
    }

    @Override
    public boolean add(Object object) {
        Gateway gateway = (Gateway) object;
        Account account = new Account();
        account.setBalance(BigDecimal.valueOf(0));
        account.setGatewayId(gateway.getId());
        this.accounts.add(account);
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

    }

    @Override
    public void list(Object object) {

    }
}
