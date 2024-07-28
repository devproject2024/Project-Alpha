package net.one97.paytm.common.entity.vipcashback;

import com.google.gsonhtcfix.a.b;

public final class GratificationSummaryData {
    @b(a = "icon")
    private String icon;
    @b(a = "message")
    private String message;
    @b(a = "totalAmount")
    private String totalAmount;

    public final String getTotalAmount() {
        return this.totalAmount;
    }

    public final void setTotalAmount(String str) {
        this.totalAmount = str;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final void setIcon(String str) {
        this.icon = str;
    }

    public final String getMessage() {
        return this.message;
    }

    public final void setMessage(String str) {
        this.message = str;
    }
}
