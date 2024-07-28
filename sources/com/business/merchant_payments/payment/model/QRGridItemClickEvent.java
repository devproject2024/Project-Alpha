package com.business.merchant_payments.payment.model;

import kotlin.g.b.k;

public final class QRGridItemClickEvent {
    public String deeplink;

    public QRGridItemClickEvent(String str) {
        k.d(str, "deeplink");
        this.deeplink = str;
    }

    public final String getDeeplink() {
        return this.deeplink;
    }

    public final void setDeeplink(String str) {
        k.d(str, "<set-?>");
        this.deeplink = str;
    }
}
