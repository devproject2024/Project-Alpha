package net.one97.paytm.common.entity.inbox.news;

import com.paytm.network.model.IJRPaytmDataModel;

public class Feed extends IJRPaytmDataModel {
    private CardInfoModel cardInfo;
    private String cardType;

    public String getCardType() {
        return this.cardType;
    }

    public void setCardType(String str) {
        this.cardType = str;
    }

    public CardInfoModel getCardInfo() {
        return this.cardInfo;
    }

    public void setCardInfo(CardInfoModel cardInfoModel) {
        this.cardInfo = cardInfoModel;
    }
}
