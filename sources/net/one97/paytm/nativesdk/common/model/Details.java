package net.one97.paytm.nativesdk.common.model;

import android.text.TextUtils;
import com.google.gson.a.c;

public class Details implements BaseDataModel {
    @c(a = "frequencyKey")
    private String frequencyKey;
    @c(a = "frequencyValue")
    private String frequencyValue;
    private boolean isDetailEmpty;
    @c(a = "nextPaymentKey")
    private String nextPaymentKey;
    @c(a = "nextPaymentValue")
    private String nextPaymentValue;

    public boolean isDetailEmpty() {
        return this.isDetailEmpty;
    }

    public void setDetailEmpty(boolean z) {
        this.isDetailEmpty = z;
    }

    public String getNextPaymentKey() {
        return this.nextPaymentKey;
    }

    public void setNextPaymentKey(String str) {
        this.nextPaymentKey = str;
    }

    public String getNextPaymentValue() {
        return this.nextPaymentValue;
    }

    public void setNextPaymentValue(String str) {
        this.nextPaymentValue = str;
    }

    public String getFrequencyValue() {
        return this.frequencyValue;
    }

    public void setFrequencyValue(String str) {
        this.frequencyValue = str;
    }

    public String getFrequencyKey() {
        return this.frequencyKey;
    }

    public void setFrequencyKey(String str) {
        this.frequencyKey = str;
    }

    public String toString() {
        if (!TextUtils.isEmpty(this.frequencyValue) || !TextUtils.isEmpty(this.nextPaymentValue)) {
            setDetailEmpty(false);
        } else {
            setDetailEmpty(true);
        }
        return super.toString();
    }
}
