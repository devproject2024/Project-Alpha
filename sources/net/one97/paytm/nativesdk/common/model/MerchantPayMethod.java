package net.one97.paytm.nativesdk.common.model;

import java.util.ArrayList;
import java.util.HashMap;

public class MerchantPayMethod implements BaseDataModel {
    private HashMap<String, Object> additionalProperties = new HashMap<>();
    private String displayName;
    private IsDisabled isDisabled;
    private ArrayList<PayChannelOption> payChannelOptions = null;
    private String payMethod;

    public String getPayMethod() {
        return this.payMethod;
    }

    public void setPayMethod(String str) {
        this.payMethod = str;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public void setDisplayName(String str) {
        this.displayName = str;
    }

    public ArrayList<PayChannelOption> getPayChannelOptions() {
        return this.payChannelOptions;
    }

    public void setPayChannelOptions(ArrayList<PayChannelOption> arrayList) {
        this.payChannelOptions = arrayList;
    }

    public IsDisabled getIsDisabled() {
        return this.isDisabled;
    }

    public void setIsDisabled(IsDisabled isDisabled2) {
        this.isDisabled = isDisabled2;
    }

    public HashMap<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String str, Object obj) {
        this.additionalProperties.put(str, obj);
    }
}
