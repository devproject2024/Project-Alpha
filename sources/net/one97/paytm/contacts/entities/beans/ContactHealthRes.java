package net.one97.paytm.contacts.entities.beans;

import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class ContactHealthRes extends IJRPaytmDataModel implements IJRDataModel {
    private String action;
    private String contactType;
    private String count;
    private String currentCount;
    private String currentLastTimestamp;
    private PaymentInstrumentHealth paymentInstruments;

    public PaymentInstrumentHealth getPaymentInstruments() {
        return this.paymentInstruments;
    }

    public void setPaymentInstruments(PaymentInstrumentHealth paymentInstrumentHealth) {
        this.paymentInstruments = paymentInstrumentHealth;
    }

    public String getCurrentCount() {
        return this.currentCount;
    }

    public void setCurrentCount(String str) {
        this.currentCount = str;
    }

    public String getCount() {
        return this.count;
    }

    public void setCount(String str) {
        this.count = str;
    }

    public String getAction() {
        return this.action;
    }

    public void setAction(String str) {
        this.action = str;
    }

    public String getContactType() {
        return this.contactType;
    }

    public void setContactType(String str) {
        this.contactType = str;
    }

    public String getCurrentLastTimestamp() {
        return this.currentLastTimestamp;
    }

    public void setCurrentLastTimestamp(String str) {
        this.currentLastTimestamp = str;
    }

    public String toString() {
        return "ClassPojo [paymentInstruments = " + this.paymentInstruments + ", currentCount = " + this.currentCount + ", count = " + this.count + ", action = " + this.action + ", contactType = " + this.contactType + ", currentLastTimestamp = " + this.currentLastTimestamp + "]";
    }
}
