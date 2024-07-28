package net.one97.paytm.upi.deeplink.model;

import net.one97.paytm.upi.common.UpiBaseDataModel;

public final class ExtraIntentParams implements UpiBaseDataModel {
    private final String minAmount;
    private final String qrExpire;
    private final String qrTs;
    private final String query;

    public ExtraIntentParams(String str, String str2, String str3, String str4) {
        this.minAmount = str;
        this.query = str2;
        this.qrExpire = str3;
        this.qrTs = str4;
    }

    public final String getMinAmount() {
        return this.minAmount;
    }

    public final String getQuery() {
        return this.query;
    }

    public final String getQrExpire() {
        return this.qrExpire;
    }

    public final String getQrTs() {
        return this.qrTs;
    }
}
