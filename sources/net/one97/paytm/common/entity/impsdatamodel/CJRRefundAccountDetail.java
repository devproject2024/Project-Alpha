package net.one97.paytm.common.entity.impsdatamodel;

import com.google.gsonhtcfix.a.b;
import java.util.HashMap;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRRefundAccountDetail implements IJRDataModel {
    @b(a = "assetId")
    private String assetId;
    @b(a = "bankName")
    private String bankName;
    @b(a = "holderName")
    private HashMap<String, String> holderName = new HashMap<>();
    @b(a = "accountId")
    private String mAccountId;
    @b(a = "maskedAccountNumber")
    private String maskedAccountNumber;

    public String getMaskedAccountNumber() {
        return this.maskedAccountNumber;
    }

    public void setMaskedAccountNumber(String str) {
        this.maskedAccountNumber = str;
    }

    public String getAssetId() {
        return this.assetId;
    }

    public void setAssetId(String str) {
        this.assetId = str;
    }

    public String getAccountId() {
        return this.mAccountId;
    }

    public void setAccountId(String str) {
        this.mAccountId = str;
    }

    public String getBankName() {
        return this.bankName;
    }

    public void setBankName(String str) {
        this.bankName = str;
    }

    public HashMap<String, String> getHolderName() {
        return this.holderName;
    }
}
