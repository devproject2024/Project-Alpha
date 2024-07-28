package net.one97.paytm.p2mNewDesign.entity;

import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.network.CJRWalletDataModel;
import net.one97.paytm.p2mNewDesign.models.IsDisabledV2;
import net.one97.paytm.p2mNewDesign.models.PayChannelOptionsV2;

public class NbPayOption extends CJRWalletDataModel implements IJRDataModel {
    private String displayName;
    private IsDisabledV2 isDisabled;
    private String isHybridDisabled;
    private ArrayList<PayChannelOptionsV2> payChannelOptions;
    private String paymentMode;

    public ArrayList<PayChannelOptionsV2> getPayChannelOptions() {
        return this.payChannelOptions;
    }

    public void setPayChannelOptions(ArrayList<PayChannelOptionsV2> arrayList) {
        this.payChannelOptions = arrayList;
    }

    public String getPaymentMode() {
        return this.paymentMode;
    }

    public void setPaymentMode(String str) {
        this.paymentMode = str;
    }

    public String getIsHybridDisabled() {
        return this.isHybridDisabled;
    }

    public void setIsHybridDisabled(String str) {
        this.isHybridDisabled = str;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public void setDisplayName(String str) {
        this.displayName = str;
    }

    public IsDisabledV2 getIsDisabled() {
        return this.isDisabled;
    }

    public void setIsDisabled(IsDisabledV2 isDisabledV2) {
        this.isDisabled = isDisabledV2;
    }

    public String toString() {
        return "ClassPojo [payChannelOptions = " + this.payChannelOptions + ", paymentMode = " + this.paymentMode + ", isHybridDisabled = " + this.isHybridDisabled + ", displayName = " + this.displayName + ", isDisabled = " + this.isDisabled + "]";
    }
}
