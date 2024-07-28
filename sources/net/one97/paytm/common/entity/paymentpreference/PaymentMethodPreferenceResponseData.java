package net.one97.paytm.common.entity.paymentpreference;

import net.one97.paytm.common.entity.IJRDataModel;

public class PaymentMethodPreferenceResponseData implements IJRDataModel {
    private String payMethod;
    private String status;

    public String getPayMethod() {
        return this.payMethod;
    }

    public void setPayMethod(String str) {
        this.payMethod = str;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }
}
