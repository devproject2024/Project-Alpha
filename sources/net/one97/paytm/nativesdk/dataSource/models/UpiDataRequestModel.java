package net.one97.paytm.nativesdk.dataSource.models;

import kotlin.g.b.k;

public final class UpiDataRequestModel {
    private final String bankAccountJson;
    private final int requestCode;
    private final String upiId;

    public UpiDataRequestModel(String str, String str2, int i2) {
        k.c(str, "upiId");
        k.c(str2, "bankAccountJson");
        this.upiId = str;
        this.bankAccountJson = str2;
        this.requestCode = i2;
    }

    public final String getUpiId() {
        return this.upiId;
    }

    public final String getBankAccountJson() {
        return this.bankAccountJson;
    }

    public final int getRequestCode() {
        return this.requestCode;
    }
}
