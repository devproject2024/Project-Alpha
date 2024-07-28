package net.one97.paytm.wallet.newdesign.models;

import com.google.gson.a.a;
import com.google.gson.a.c;
import net.one97.paytm.network.CJRWalletDataModel;

public class GetRecentPaymentsResponse extends CJRWalletDataModel {
    @c(a = "amount")
    @a
    private String amount;
    @c(a = "imageUrl")
    @a
    private String imageUrl;
    @c(a = "merchantId")
    @a
    private String merchantId;
    @c(a = "name")
    @a
    private String name;
    @c(a = "phoneNumber")
    @a
    private String phoneNumber;
    @c(a = "scanResult")
    @a
    private String scanResult;
    @c(a = "timestamp")
    @a
    private String timestamp;
    @c(a = "type")
    @a
    private String type;

    public String getAmount() {
        return this.amount;
    }

    public void setAmount(String str) {
        this.amount = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String str) {
        this.phoneNumber = str;
    }

    public String getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(String str) {
        this.timestamp = str;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public void setImageUrl(String str) {
        this.imageUrl = str;
    }

    public String getScanResult() {
        return this.scanResult;
    }

    public void setScanResult(String str) {
        this.scanResult = str;
    }

    public String getMerchantId() {
        return this.merchantId;
    }

    public void setMerchantId(String str) {
        this.merchantId = str;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }
}
