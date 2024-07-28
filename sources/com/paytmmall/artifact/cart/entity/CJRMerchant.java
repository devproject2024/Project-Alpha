package com.paytmmall.artifact.cart.entity;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.HashMap;

public class CJRMerchant extends IJRPaytmDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "is_C2I_Merchant")
    private int isInternationalized;
    @b(a = "address")
    private HashMap<String, String> mMerchantAdress;
    @b(a = "merchant_id")
    private String mMerchantID;
    @b(a = "merchant_image")
    private String mMerchantImage;
    @b(a = "merchant_name")
    private String mMerchantName;
    @b(a = "paytm_verified")
    private int mPaytmVerified;

    public String getMerchantID() {
        return this.mMerchantID;
    }

    public String getMerchantImage() {
        return this.mMerchantImage;
    }

    public String getMerchantName() {
        return this.mMerchantName;
    }

    public HashMap<String, String> getmMerchantAdress() {
        return this.mMerchantAdress;
    }

    public int getIsInternationalized() {
        return this.isInternationalized;
    }

    public void setIsInternationalized(int i2) {
        this.isInternationalized = i2;
    }

    public int getmPaytmVerified() {
        return this.mPaytmVerified;
    }

    public void setmMerchantID(String str) {
        this.mMerchantID = str;
    }

    public void setmMerchantName(String str) {
        this.mMerchantName = str;
    }

    public void setmMerchantAdress(HashMap<String, String> hashMap) {
        this.mMerchantAdress = hashMap;
    }
}
