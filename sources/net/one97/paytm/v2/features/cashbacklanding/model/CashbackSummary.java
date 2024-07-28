package net.one97.paytm.v2.features.cashbacklanding.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public final class CashbackSummary extends IJRPaytmDataModel {
    @b(a = "amount")
    private String amount;
    @b(a = "categoryLabel")
    private String categoryLabel;
    @b(a = "categoryMessage")
    private String categoryMessage;
    @b(a = "categoryType")
    private String categoryType;
    @b(a = "deeplink")
    private String deeplink;
    @b(a = "icon")
    private String icon;

    public final String getCategoryType() {
        return this.categoryType;
    }

    public final void setCategoryType(String str) {
        this.categoryType = str;
    }

    public final String getCategoryMessage() {
        return this.categoryMessage;
    }

    public final void setCategoryMessage(String str) {
        this.categoryMessage = str;
    }

    public final String getAmount() {
        return this.amount;
    }

    public final void setAmount(String str) {
        this.amount = str;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final void setIcon(String str) {
        this.icon = str;
    }

    public final String getDeeplink() {
        return this.deeplink;
    }

    public final void setDeeplink(String str) {
        this.deeplink = str;
    }

    public final String getCategoryLabel() {
        return this.categoryLabel;
    }

    public final void setCategoryLabel(String str) {
        this.categoryLabel = str;
    }
}
