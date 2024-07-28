package net.one97.paytm.common.entity.vipcashback;

import net.one97.paytm.common.entity.IJRDataModel;

public class CashbackDeeplinkItem implements IJRDataModel {
    private static final long serialVersionUID = 1;
    private String cashbackCampaignId;
    private String cashbackOfferId;
    private String cashbackOfferTag;
    private String cashbackScreen;
    private Integer cashbackTxnNo;
    private boolean showCashbackHomeBack;

    public Integer getCashbackTxnNo() {
        return this.cashbackTxnNo;
    }

    public void setCashbackTxnNo(Integer num) {
        this.cashbackTxnNo = num;
    }

    public String getCashbackOfferTag() {
        return this.cashbackOfferTag;
    }

    public void setCashbackOfferTag(String str) {
        this.cashbackOfferTag = str;
    }

    public String getCashbackScreen() {
        return this.cashbackScreen;
    }

    public void setCashbackScreen(String str) {
        this.cashbackScreen = str;
    }

    public String getCashbackOfferId() {
        return this.cashbackOfferId;
    }

    public void setCashbackOfferId(String str) {
        this.cashbackOfferId = str;
    }

    public String getCashbackCampaignId() {
        return this.cashbackCampaignId;
    }

    public void setCashbackCampaignId(String str) {
        this.cashbackCampaignId = str;
    }

    public boolean getShowCashbackHomeBack() {
        return this.showCashbackHomeBack;
    }

    public void setShowCashbackHomeBack(boolean z) {
        this.showCashbackHomeBack = z;
    }
}
