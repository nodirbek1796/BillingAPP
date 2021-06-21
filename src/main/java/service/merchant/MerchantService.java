package service.merchant;

import model.card.Card;
import model.gateway.Currency;
import model.gateway.Gateway;
import model.merchant.Merchant;
import service.base.BaseService;

import java.math.BigDecimal;
import java.util.ArrayList;

public class MerchantService extends BaseService {

    ArrayList<Merchant> merchants = new ArrayList<>();

    @Override
    public boolean add(Object object, Object object1) {
        Merchant newMerchant = (Merchant) object;
        boolean isHasMerchant = false;
        for (int i = 0; i < this.merchants.size() && !isHasMerchant; i++) {
            if (this.merchants.get(i) != null) {
                if (this.merchants.get(i).getId() == (newMerchant.getId()))
                    isHasMerchant = true;
            }
        }
        if (!isHasMerchant)
            this.merchants.add(newMerchant);

        return !isHasMerchant;
        
    }

    public Merchant getMerchant(int merchantId){
        Merchant service = null;
        for (Merchant merchant : this.merchants)
                if (merchant.getId() == merchantId){
                    service = merchant;
                    break;
                }
        return service;
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

    public void helper(){
        Merchant merchant = new Merchant(
                94,
                "beeline",
                BigDecimal.valueOf(1000),
                BigDecimal.valueOf(1000000),
                false
        );
        Merchant merchant1 = new Merchant(
                93,
                "ucell",
                BigDecimal.valueOf(1000),
                BigDecimal.valueOf(1000000),
                false
        );
        Merchant merchant2 = new Merchant(
                1000,
                "qiwi",
                BigDecimal.valueOf(1000),
                BigDecimal.valueOf(1000000),
                false
        );
        Merchant merchant3 = new Merchant(
                100,
                "web_money",
                BigDecimal.valueOf(1000),
                BigDecimal.valueOf(1000000),
                false
        );
        this.merchants.add(merchant);
        this.merchants.add(merchant1);
        this.merchants.add(merchant2);
        this.merchants.add(merchant3);
    }
}
