package model.history;

import model.base.BaseModel;

import java.util.UUID;

public class History extends BaseModel {
    private UUID p2pId;
    private UUID paymentId;
    private UUID userId;

    public History() {
    }

    public History(String name, UUID p2pId, UUID paymentId, UUID userId) {
        super(name);
        this.p2pId = p2pId;
        this.paymentId = paymentId;
        this.userId = userId;
    }

    public UUID getP2pId() {
        return p2pId;
    }

    public void setP2pId(UUID p2pId) {
        this.p2pId = p2pId;
    }

    public UUID getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(UUID paymentId) {
        this.paymentId = paymentId;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }
}
