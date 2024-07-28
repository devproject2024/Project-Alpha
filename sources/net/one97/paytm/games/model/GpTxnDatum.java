package net.one97.paytm.games.model;

import com.android.billingclient.api.g;
import com.google.gson.a.c;

public class GpTxnDatum {
    @c(a = "accountId")
    private String accountId;
    @c(a = "purchaseTime")
    private long purchaseTime;
    @c(a = "purchaseToken")
    private String purchaseToken;
    @c(a = "skuId")
    private String skuId;
    @c(a = "skuType")
    private String skuType;
    @c(a = "spsTxnId")
    private String spsTxnId;

    public GpTxnDatum(g gVar, String str, String str2, String str3) {
        if (gVar != null) {
            this.skuId = gVar.a();
            this.purchaseTime = gVar.f30954a.optLong("purchaseTime");
            this.purchaseToken = gVar.b();
        }
        this.skuType = str;
        this.spsTxnId = str2;
        this.accountId = str3;
    }

    public GpTxnDatum(String str, String str2, String str3, long j, String str4, String str5) {
        this.skuId = str;
        this.skuType = str2;
        this.purchaseToken = str3;
        this.purchaseTime = j;
        this.spsTxnId = str4;
        this.accountId = str5;
    }

    public String getSkuId() {
        return this.skuId;
    }

    public String getSkuType() {
        return this.skuType;
    }

    public String getPurchaseToken() {
        return this.purchaseToken;
    }

    public long getPurchaseTime() {
        return this.purchaseTime;
    }

    public String getSpsTxnId() {
        return this.spsTxnId;
    }
}
