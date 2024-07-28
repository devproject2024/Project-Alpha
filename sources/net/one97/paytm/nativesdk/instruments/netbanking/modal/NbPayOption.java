package net.one97.paytm.nativesdk.instruments.netbanking.modal;

import java.util.ArrayList;

public class NbPayOption {
    private String displayName;
    private IsDisabled isDisabled;
    private ArrayList<PayChannelOptions> payChannelOptions;
    private String paymentMode;

    public IsDisabled getIsDisabled() {
        return this.isDisabled;
    }

    public void setIsDisabled(IsDisabled isDisabled2) {
        this.isDisabled = isDisabled2;
    }

    public String getPaymentMode() {
        return this.paymentMode;
    }

    public void setPaymentMode(String str) {
        this.paymentMode = str;
    }

    public ArrayList<PayChannelOptions> getPayChannelOptions() {
        return this.payChannelOptions;
    }

    public void setPayChannelOptions(ArrayList<PayChannelOptions> arrayList) {
        this.payChannelOptions = arrayList;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public void setDisplayName(String str) {
        this.displayName = str;
    }

    public String toString() {
        return "ClassPojo [isDisabled = " + this.isDisabled + ", paymentMode = " + this.paymentMode + ", payChannelOptions = " + this.payChannelOptions + ", displayName = " + this.displayName + "]";
    }
}
