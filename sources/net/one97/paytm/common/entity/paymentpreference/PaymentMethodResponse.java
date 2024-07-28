package net.one97.paytm.common.entity.paymentpreference;

import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class PaymentMethodResponse extends IJRPaytmDataModel implements IJRDataModel {
    private ArrayList<PaymentMethodPreferenceResponseData> data;
    private boolean isSwap;
    private String message;
    private String responseCode;
    private String status;

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public String getResponseCode() {
        return this.responseCode;
    }

    public void setResponseCode(String str) {
        this.responseCode = str;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public ArrayList<PaymentMethodPreferenceResponseData> getData() {
        return this.data;
    }

    public void setData(ArrayList<PaymentMethodPreferenceResponseData> arrayList) {
        this.data = arrayList;
    }

    public boolean isSwap() {
        return this.isSwap;
    }

    public void setSwap(boolean z) {
        this.isSwap = z;
    }
}
