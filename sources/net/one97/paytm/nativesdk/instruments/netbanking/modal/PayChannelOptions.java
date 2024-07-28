package net.one97.paytm.nativesdk.instruments.netbanking.modal;

import androidx.databinding.ObservableBoolean;
import com.google.gson.a.a;
import com.google.gson.a.c;
import net.one97.paytm.nativesdk.common.model.BaseDataModel;
import net.one97.paytm.nativesdk.common.model.MinAmount;

public class PayChannelOptions implements BaseDataModel {
    private String channelCode;
    private String channelName;
    private String emiType;
    public ObservableBoolean greenTickVisible = new ObservableBoolean(false);
    private HasLowSuccess hasLowSuccess;
    private String iconUrl;
    private IsDisabled isDisabled;
    public boolean isProceedVisible;
    @c(a = "maxAmount")
    @a
    private MinAmount maxAmount;
    @c(a = "minAmount")
    @a
    private MinAmount minAmount;

    public IsDisabled getIsDisabled() {
        return this.isDisabled;
    }

    public void setIsDisabled(IsDisabled isDisabled2) {
        this.isDisabled = isDisabled2;
    }

    public String getChannelName() {
        return this.channelName;
    }

    public void setChannelName(String str) {
        this.channelName = str;
    }

    public String getChannelCode() {
        return this.channelCode;
    }

    public String getEmiType() {
        return this.emiType;
    }

    public void setEmiType(String str) {
        this.emiType = str;
    }

    public void setChannelCode(String str) {
        this.channelCode = str;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public void setIconUrl(String str) {
        this.iconUrl = str;
    }

    public HasLowSuccess getHasLowSuccess() {
        return this.hasLowSuccess;
    }

    public void setHasLowSuccess(HasLowSuccess hasLowSuccess2) {
        this.hasLowSuccess = hasLowSuccess2;
    }

    public boolean isProceedVisible() {
        return this.isProceedVisible;
    }

    public void setProceedVisible(boolean z) {
        this.isProceedVisible = z;
    }

    public String toString() {
        return "ClassPojo [isDisabled = " + this.isDisabled + ", channelName = " + this.channelName + ", channelCode = " + this.channelCode + ", iconUrl = " + this.iconUrl + ", hasLowSuccess = " + this.hasLowSuccess + "]";
    }

    public MinAmount getMaxAmount() {
        return this.maxAmount;
    }

    public void setMaxAmount(MinAmount minAmount2) {
        this.maxAmount = minAmount2;
    }

    public MinAmount getMinAmount() {
        return this.minAmount;
    }

    public void setMinAmount(MinAmount minAmount2) {
        this.minAmount = minAmount2;
    }
}
