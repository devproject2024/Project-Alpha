package net.one97.paytm.recharge.model.imps;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.HashMap;

public final class CJRWalletViewV8 extends IJRPaytmDataModel {
    @b(a = "amount")
    private final HashMap<String, String> amount = new HashMap<>();
    @b(a = "custom_texts")
    private HashMap<String, String> custom_texts;
    @b(a = "destination")
    private String destination;
    @b(a = "destinationSubText")
    private String destinationSubText;
    @b(a = "destinationText")
    private String destinationText;
    @b(a = "maxRefundTime")
    private final HashMap<String, String> maxRefundTime;

    public final String getDestination() {
        return this.destination;
    }

    public final void setDestination(String str) {
        this.destination = str;
    }

    public final String getDestinationText() {
        return this.destinationText;
    }

    public final void setDestinationText(String str) {
        this.destinationText = str;
    }

    public final String getDestinationSubText() {
        return this.destinationSubText;
    }

    public final void setDestinationSubText(String str) {
        this.destinationSubText = str;
    }

    public final HashMap<String, String> getAmount() {
        return this.amount;
    }

    public final HashMap<String, String> getMaxRefundTime() {
        return this.maxRefundTime;
    }

    public final HashMap<String, String> getCustom_texts() {
        return this.custom_texts;
    }

    public final void setCustom_texts(HashMap<String, String> hashMap) {
        this.custom_texts = hashMap;
    }
}
