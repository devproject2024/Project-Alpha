package net.one97.paytm.wallet.newdesign.models;

import com.google.gson.a.a;
import com.google.gson.a.c;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.network.CJRWalletDataModel;
import org.json.JSONException;
import org.json.JSONObject;

public class UpdateRecentPaymentsModel extends CJRWalletDataModel {
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
    private long timestamp;
    @c(a = "type")
    @a
    private String type;

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

    public String getImageUrl() {
        return this.imageUrl;
    }

    public void setImageUrl(String str) {
        this.imageUrl = str;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(long j) {
        this.timestamp = j;
    }

    public String getAmount() {
        return this.amount;
    }

    public void setAmount(String str) {
        this.amount = str;
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

    public String getScanResult() {
        return this.scanResult;
    }

    public void setScanResult(String str) {
        this.scanResult = str;
    }

    public JSONObject getJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", this.name);
            jSONObject.put("phoneNumber", this.phoneNumber);
            jSONObject.put("imageUrl", this.imageUrl);
            jSONObject.put("timestamp", this.timestamp);
            jSONObject.put("amount", this.amount);
            jSONObject.put(SDKConstants.KEY_MERCHANT_ID, this.merchantId);
            jSONObject.put("type", this.type);
            jSONObject.put("scanResult", this.scanResult);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}
