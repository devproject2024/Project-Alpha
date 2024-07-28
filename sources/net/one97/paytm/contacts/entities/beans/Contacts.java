package net.one97.paytm.contacts.entities.beans;

import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class Contacts extends IJRPaytmDataModel implements IJRDataModel {
    private String contactType;
    private int count;
    private PaymentInstrumentsReqt paymentInstruments;

    public String getContactType() {
        return this.contactType;
    }

    public void setContactType(String str) {
        this.contactType = str;
    }

    public int getCount() {
        return this.count;
    }

    public void setCount(int i2) {
        this.count = i2;
    }

    public PaymentInstrumentsReqt getPaymentInstruments() {
        return this.paymentInstruments;
    }

    public void setPaymentInstruments(PaymentInstrumentsReqt paymentInstrumentsReqt) {
        this.paymentInstruments = paymentInstrumentsReqt;
    }
}
