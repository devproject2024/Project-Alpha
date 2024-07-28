package com.paytmmall.artifact.order.entity.impsdataentity;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.HashMap;

public class CJRWalletView extends IJRPaytmDataModel {
    @b(a = "amount")
    private HashMap<String, String> amount = new HashMap<>();
    @b(a = "custom_texts")
    private HashMap<String, String> custom_texts;
    @b(a = "destination")
    private String destination;
    @b(a = "destinationSubText")
    private String destinationSubText;
    @b(a = "destinationText")
    private String destinationText;
    @b(a = "maxRefundTime")
    private HashMap<String, String> maxRefundTime;

    public String getDestination() {
        return this.destination;
    }

    public void setDestination(String str) {
        this.destination = str;
    }

    public String getDestinationText() {
        return this.destinationText;
    }

    public void setDestinationText(String str) {
        this.destinationText = str;
    }

    public String getDestinationSubText() {
        return this.destinationSubText;
    }

    public void setDestinationSubText(String str) {
        this.destinationSubText = str;
    }

    public HashMap<String, String> getAmount() {
        return this.amount;
    }

    public HashMap<String, String> getMaxRefundTime() {
        return this.maxRefundTime;
    }

    public HashMap<String, String> getCustom_texts() {
        return this.custom_texts;
    }

    public void setCustom_texts(HashMap<String, String> hashMap) {
        this.custom_texts = hashMap;
    }
}
