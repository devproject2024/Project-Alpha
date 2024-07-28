package net.one97.paytm.common.entity;

import com.google.gsonhtcfix.a.b;

public class CJRMerchantEntity implements IJRDataModel {
    @b(a = "clientId")
    private String mClientId;
    @b(a = "clientName")
    private String mClientName;

    public String getClientId() {
        return this.mClientId;
    }

    public void setClientId(String str) {
        this.mClientId = str;
    }

    public String getClientName() {
        return this.mClientName;
    }

    public void setClientName(String str) {
        this.mClientName = str;
    }
}
