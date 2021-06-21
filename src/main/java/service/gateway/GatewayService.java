package service.gateway;

import model.gateway.Currency;
import model.gateway.Gateway;
import model.merchant.Merchant;
import service.account.AccountService;
import service.base.BaseService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GatewayService extends BaseService {

    List<Gateway> gateways = new ArrayList<>();

    @Override
    public boolean add(Object object, Object object1) {
        Gateway gateway = (Gateway) object;
        AccountService accountService = (AccountService) object1;
        accountService.add(gateway);
        boolean success = gateways.add(gateway);
        return success;
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

    }

    public Gateway getGateway(
            Merchant merchant
    ) {
        Gateway gateway = gateways.stream().filter(
                (gat -> gat.getMerchantId() == merchant.getId())
        ).collect(Collectors.toList()).stream().findFirst().get();

        return gateway;
    }

    public void helper(){
        Gateway gateway = new Gateway(
                100,
                "beeline",
                Currency.SUM,
                BigDecimal.valueOf(1000),
                BigDecimal.valueOf(1000000),
                BigDecimal.valueOf(0),
                BigDecimal.valueOf(2),
                94
        );
        Gateway gateway1 = new Gateway(
                1000,
                "ucell",
                Currency.SUM,
                BigDecimal.valueOf(1000),
                BigDecimal.valueOf(1000000),
                BigDecimal.valueOf(0),
                BigDecimal.valueOf(2),
                93
        );
        Gateway qiwi = new Gateway(
                2000,
                "qiwi",
                Currency.USD,
                BigDecimal.valueOf(1000),
                BigDecimal.valueOf(1000000),
                BigDecimal.valueOf(0),
                BigDecimal.valueOf(2),
                1000
        );

        Gateway webMoney = new Gateway(
                3000,
                "web_money",
                Currency.RUB,
                BigDecimal.valueOf(1000),
                BigDecimal.valueOf(1000000),
                BigDecimal.valueOf(0),
                BigDecimal.valueOf(2),
                100
        );
        this.gateways.add(gateway);
        this.gateways.add(gateway1);
        this.gateways.add(qiwi);
        this.gateways.add(webMoney);
    }

}
