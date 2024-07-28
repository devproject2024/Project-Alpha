package net.one97.paytm.common.entity.vipcashback;

import com.google.gsonhtcfix.a.b;

public class CashbackVoucher {
    private static final long serialVersionUID = 1;
    @b(a = "bgImage")
    private String bgImage;
    @b(a = "client")
    private String client;
    @b(a = "displayCode")
    private String displayCode;
    @b(a = "expireSoon")
    private String expireSoon;
    private String formattedVoucherCode;
    @b(a = "icon")
    private String icon;
    @b(a = "promocode")
    private String promocode;
    @b(a = "redemptionType")
    private String redemptionType;
    @b(a = "savingsText")
    private String savingsText;
    @b(a = "siteId")
    private String siteId;
    @b(a = "title")
    private String title;
    @b(a = "usageText")
    private String usageText;

    public String getExpireSoon() {
        return this.expireSoon;
    }

    public void setExpireSoon(String str) {
        this.expireSoon = str;
    }

    public String getSavingsText() {
        return this.savingsText;
    }

    public void setSavingsText(String str) {
        this.savingsText = str;
    }

    public String getIcon() {
        return this.icon;
    }

    public void setIcon(String str) {
        this.icon = str;
    }

    public String getPromocode() {
        return this.promocode;
    }

    public void setPromocode(String str) {
        this.promocode = str;
    }

    public String getSiteId() {
        return this.siteId;
    }

    public void setSiteId(String str) {
        this.siteId = str;
    }

    public String getUsageText() {
        return this.usageText;
    }

    public void setUsageText(String str) {
        this.usageText = str;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getBgImage() {
        return this.bgImage;
    }

    public String getFormattedVoucherCode() {
        return this.formattedVoucherCode;
    }

    public void setFormattedVoucherCode(String str) {
        this.formattedVoucherCode = str;
    }

    public String getDisplayCode() {
        return this.displayCode;
    }

    public void setDisplayCode(String str) {
        this.displayCode = str;
    }

    public String getClient() {
        return this.client;
    }

    public void setClient(String str) {
        this.client = str;
    }

    public String getRedemptionType() {
        return this.redemptionType;
    }

    public void setRedemptionType(String str) {
        this.redemptionType = str;
    }

    public String toString() {
        return "ClassPojo [expireSoon = " + this.expireSoon + ", savingsText = " + this.savingsText + ", icon = " + this.icon + ", promocode = " + this.promocode + ", siteId = " + this.siteId + ", usageText = " + this.usageText + ", title = " + this.title + "]";
    }
}
