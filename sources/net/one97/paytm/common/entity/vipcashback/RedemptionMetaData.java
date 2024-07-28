package net.one97.paytm.common.entity.vipcashback;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import net.one97.paytm.cashback.posttxn.CashBackBaseModal;

public class RedemptionMetaData extends CashBackBaseModal {
    @b(a = "amount")
    private String amount;
    @b(a = "dealId")
    private String dealId;
    @b(a = "deeplink")
    private String deeplink;
    @b(a = "flip")
    private boolean flip;
    @b(a = "redeemedTime")
    private Long redeemedTime;
    @b(a = "redemptionDelay")
    private ArrayList<RedemptionDelay> redemptionDelay;
    @b(a = "redemptionIconUrl")
    private String redemptionIconUrl;
    @b(a = "redemptionType")
    private String redemptionType;
    @b(a = "secret")
    private String secret;
    @b(a = "validFrom")
    private String validFrom;
    @b(a = "validUpto")
    private String validUpto;
    @b(a = "voucherCode")
    private String voucherCode;
    @b(a = "voucherDeeplink")
    private String voucherDeeplink;
    @b(a = "voucherName")
    private String voucherName;

    public String getAmount() {
        return this.amount;
    }

    public void setAmount(String str) {
        this.amount = str;
    }

    public String getVoucherName() {
        return this.voucherName;
    }

    public void setVoucherName(String str) {
        this.voucherName = str;
    }

    public String getRedemptionType() {
        return this.redemptionType;
    }

    public void setRedemptionType(String str) {
        this.redemptionType = str;
    }

    public String getRedemptionIconUrl() {
        return this.redemptionIconUrl;
    }

    public void setRedemptionIconUrl(String str) {
        this.redemptionIconUrl = str;
    }

    public String getValidUpto() {
        return this.validUpto;
    }

    public void setValidUpto(String str) {
        this.validUpto = str;
    }

    public String getDealId() {
        return this.dealId;
    }

    public void setDealId(String str) {
        this.dealId = str;
    }

    public ArrayList<RedemptionDelay> getRedemptionDelay() {
        return this.redemptionDelay;
    }

    public String getValidFrom() {
        return this.validFrom;
    }

    public void setValidFrom(String str) {
        this.validFrom = str;
    }

    public String getSecret() {
        return this.secret;
    }

    public void setSecret(String str) {
        this.secret = str;
    }

    public String getVoucherDeeplink() {
        return this.voucherDeeplink;
    }

    public void setVoucherDeeplink(String str) {
        this.voucherDeeplink = str;
    }

    public Long getRedeemedTime() {
        return this.redeemedTime;
    }

    public void setRedeemedTime(Long l) {
        this.redeemedTime = l;
    }

    public String getVoucherCode() {
        return this.voucherCode;
    }

    public void setVoucherCode(String str) {
        this.voucherCode = str;
    }

    public String getDeeplink() {
        return this.deeplink;
    }

    public boolean isFlip() {
        return this.flip;
    }
}
