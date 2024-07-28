package net.one97.paytm.common.entity.offline_pg;

import net.one97.paytm.common.entity.IJRDataModel;

public class MerchantInfo implements IJRDataModel {
    String currentTxnCount;
    String mccCode;
    String name;

    public void setName(String str) {
        this.name = str;
    }

    public void setMccCode(String str) {
        this.mccCode = str;
    }

    public void setCurrentTxnCount(String str) {
        this.currentTxnCount = str;
    }

    public String getName() {
        return this.name;
    }

    public String getMccCode() {
        return this.mccCode;
    }

    public String getCurrentTxnCount() {
        return this.currentTxnCount;
    }
}
