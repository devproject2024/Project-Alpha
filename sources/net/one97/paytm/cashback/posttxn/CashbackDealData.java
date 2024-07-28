package net.one97.paytm.cashback.posttxn;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CashbackDealData extends IJRPaytmDataModel {
    private String amount;
    @b(a = "deal_voucher_code")
    private String dealCode;
    @b(a = "deal_expiry")
    private String dealExpiry;
    @b(a = "deal_icon")
    private String dealIcon;
    @b(a = "deal_redemption_terms")
    private String dealRedemptionTerms;
    @b(a = "deal_terms")
    private String dealTerms;
    @b(a = "deal_text")
    private String dealText;
    @b(a = "deal_usage_text")
    private String dealUsageText;
    @b(a = "deal_valid_from")
    private String dealValidFrom;
    @b(a = "frontend_redemption_type")
    private String frontendRedemptionType;
    @b(a = "hasOfferText")
    private int hasOfferText;
    @b(a = "hasTnc")
    private int hasTnc;
    @b(a = "id")
    private String id;
    private String offerName;
    @b(a = "secret")
    private String secretPin;

    public int getHasOfferText() {
        return this.hasOfferText;
    }

    public String getDealTerms() {
        return this.dealTerms;
    }

    public String getDealUsageText() {
        return this.dealUsageText;
    }

    public String getDealRedemptionTerms() {
        return this.dealRedemptionTerms;
    }

    public String getDealIcon() {
        return this.dealIcon;
    }

    public String getDealText() {
        return this.dealText;
    }

    public int getHasTnc() {
        return this.hasTnc;
    }

    public String getDealValidFrom() {
        return this.dealValidFrom;
    }

    public String getDealExpiry() {
        return this.dealExpiry;
    }

    public String getId() {
        return this.id;
    }

    public String getDealCode() {
        return this.dealCode;
    }

    public String getSecretPin() {
        return this.secretPin;
    }

    public String getFrontendRedemptionType() {
        return this.frontendRedemptionType;
    }

    public String getAmount() {
        return this.amount;
    }

    public String getOfferName() {
        return this.offerName;
    }

    public void setAmount(String str) {
        this.amount = str;
    }

    public void setOfferName(String str) {
        this.offerName = str;
    }
}
