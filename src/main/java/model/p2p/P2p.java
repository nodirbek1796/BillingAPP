package model.p2p;

import model.base.BaseModel;

import java.math.BigDecimal;
import java.util.UUID;

public class P2p extends BaseModel {

    private UUID sourceCardId;
    private UUID destinationCardId;
    private BigDecimal transferAmount;
    private Double commissionUp;

    public P2p() {
    }

    public P2p(String name, UUID sourceCardId, UUID destinationCardId, BigDecimal transferAmount, Double commissionUp) {
        super(name);
        this.sourceCardId = sourceCardId;
        this.destinationCardId = destinationCardId;
        this.transferAmount = transferAmount;
        this.commissionUp = commissionUp;
    }

    public UUID getSourceCardId() {
        return sourceCardId;
    }

    public void setSourceCardId(UUID sourceCardId) {
        this.sourceCardId = sourceCardId;
    }

    public UUID getDestinationCardId() {
        return destinationCardId;
    }

    public void setDestinationCardId(UUID destinationCardId) {
        this.destinationCardId = destinationCardId;
    }

    public BigDecimal getTransferAmount() {
        return transferAmount;
    }

    public void setTransferAmount(BigDecimal transferAmount) {
        this.transferAmount = transferAmount;
    }

    public Double getCommissionUp() {
        return commissionUp;
    }

    public void setCommissionUp(Double commissionUp) {
        this.commissionUp = commissionUp;
    }
}
