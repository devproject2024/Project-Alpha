package net.one97.paytm.v2.features.cashbacklanding.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.cashback.posttxn.Campaign;
import net.one97.paytm.cashback.posttxn.VIPCashBackOfferV4;
import net.one97.paytm.common.entity.vipcashback.ScratchCard;

public final class CardOfferData extends IJRPaytmDataModel {
    @b(a = "activeOfferData")
    private VIPCashBackOfferV4 activeOfferData;
    @b(a = "type")
    private String cardType;
    @b(a = "lockedCardData")
    private ScratchCard lockedCardData;
    @b(a = "message")
    private String message;
    @b(a = "newOfferData")
    private Campaign newOfferData;
    private Integer scratchableImage;
    @b(a = "unscratchedCardData")
    private ScratchCard unscratchedCardData;

    public final String getCardType() {
        return this.cardType;
    }

    public final void setCardType(String str) {
        this.cardType = str;
    }

    public final String getMessage() {
        return this.message;
    }

    public final void setMessage(String str) {
        this.message = str;
    }

    public final Integer getScratchableImage() {
        return this.scratchableImage;
    }

    public final void setScratchableImage(Integer num) {
        this.scratchableImage = num;
    }

    public final ScratchCard getUnscratchedCardData() {
        return this.unscratchedCardData;
    }

    public final void setUnscratchedCardData(ScratchCard scratchCard) {
        this.unscratchedCardData = scratchCard;
    }

    public final ScratchCard getLockedCardData() {
        return this.lockedCardData;
    }

    public final void setLockedCardData(ScratchCard scratchCard) {
        this.lockedCardData = scratchCard;
    }

    public final VIPCashBackOfferV4 getActiveOfferData() {
        return this.activeOfferData;
    }

    public final void setActiveOfferData(VIPCashBackOfferV4 vIPCashBackOfferV4) {
        this.activeOfferData = vIPCashBackOfferV4;
    }

    public final Campaign getNewOfferData() {
        return this.newOfferData;
    }

    public final void setNewOfferData(Campaign campaign) {
        this.newOfferData = campaign;
    }
}
