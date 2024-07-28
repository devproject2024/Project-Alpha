package net.one97.paytm.contacts.entities.beans;

import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class PaymentInstrument extends IJRPaytmDataModel implements IJRDataModel {
    Object meta;
    private String paymentInstrumentId;
    private String paymentInstrumentRefId;
    private String recentNewValidityExpiryTime;
    private String score;
    private String status;
    private String type;

    public PaymentInstrument(String str, String str2, String str3, String str4, Object obj) {
        this.paymentInstrumentId = str;
        this.type = str2;
        this.score = str3;
        this.status = str4;
        this.meta = obj;
    }

    public String getPaymentInstrumentId() {
        return this.paymentInstrumentId;
    }

    public String getType() {
        return this.type;
    }

    public String getScore() {
        return this.score;
    }

    public String getStatus() {
        return this.status;
    }

    public Object getMeta() {
        return this.meta;
    }

    public String getPaymentInstrumentRefId() {
        return this.paymentInstrumentRefId;
    }

    public String getRecentNewValidityExpiryTime() {
        return this.recentNewValidityExpiryTime;
    }
}
