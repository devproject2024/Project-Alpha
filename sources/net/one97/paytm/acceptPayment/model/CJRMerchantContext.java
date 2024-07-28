package net.one97.paytm.acceptPayment.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;

public class CJRMerchantContext extends IJRPaytmDataModel {
    @b(a = "currentMerchant")
    private long currentMerchantId;
    @b(a = "id")
    private String mId;
    @b(a = "merchants")
    private ArrayList<CJRMerchantContextListObject> mMerchants;
    @b(a = "username")
    private String mUsername;

    public long getCurrentMerchantId() {
        return this.currentMerchantId;
    }

    public String getId() {
        return this.mId;
    }

    public void setId(String str) {
        this.mId = this.mId;
    }

    public String getUsername() {
        return this.mUsername;
    }

    public void setUsername(String str) {
        this.mUsername = str;
    }

    public ArrayList<CJRMerchantContextListObject> getMerchants() {
        return this.mMerchants;
    }

    public void setMerchants(ArrayList<CJRMerchantContextListObject> arrayList) {
        this.mMerchants = arrayList;
    }
}
