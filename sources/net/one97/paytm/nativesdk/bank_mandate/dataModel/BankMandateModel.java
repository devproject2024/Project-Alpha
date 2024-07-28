package net.one97.paytm.nativesdk.bank_mandate.dataModel;

import com.google.gson.a.a;
import com.google.gson.a.c;
import java.util.List;
import net.one97.paytm.nativesdk.common.model.BaseDataModel;
import net.one97.paytm.nativesdk.instruments.netbanking.modal.HasLowSuccess;
import net.one97.paytm.nativesdk.instruments.netbanking.modal.IsDisabled;

public class BankMandateModel implements BaseDataModel {
    @c(a = "channelCode")
    @a
    private String channelCode;
    @c(a = "channelName")
    @a
    private String channelName;
    @c(a = "hasLowSuccess")
    @a
    private HasLowSuccess hasLowSuccess;
    @c(a = "iconUrl")
    @a
    private String iconUrl;
    @c(a = "isDisabled")
    @a
    private IsDisabled isDisabled;
    @c(a = "isHybridDisabled")
    @a
    private Boolean isHybridDisabled;
    @c(a = "mandateAuthMode")
    @a
    private List<String> mandateAuthMode = null;
    @c(a = "mandateBankCode")
    @a
    private String mandateBankCode;
    @c(a = "mandateMode")
    @a
    private String mandateMode;

    public String getMandateMode() {
        return this.mandateMode;
    }

    public void setMandateMode(String str) {
        this.mandateMode = str;
    }

    public List<String> getMandateAuthMode() {
        return this.mandateAuthMode;
    }

    public void setMandateAuthMode(List<String> list) {
        this.mandateAuthMode = list;
    }

    public String getMandateBankCode() {
        return this.mandateBankCode;
    }

    public void setMandateBankCode(String str) {
        this.mandateBankCode = str;
    }

    public IsDisabled getIsDisabled() {
        return this.isDisabled;
    }

    public void setIsDisabled(IsDisabled isDisabled2) {
        this.isDisabled = isDisabled2;
    }

    public HasLowSuccess getHasLowSuccess() {
        return this.hasLowSuccess;
    }

    public void setHasLowSuccess(HasLowSuccess hasLowSuccess2) {
        this.hasLowSuccess = hasLowSuccess2;
    }

    public Boolean getIsHybridDisabled() {
        return this.isHybridDisabled;
    }

    public void setIsHybridDisabled(Boolean bool) {
        this.isHybridDisabled = bool;
    }

    public String getChannelCode() {
        return this.channelCode;
    }

    public void setChannelCode(String str) {
        this.channelCode = str;
    }

    public String getChannelName() {
        return this.channelName;
    }

    public void setChannelName(String str) {
        this.channelName = str;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public void setIconUrl(String str) {
        this.iconUrl = str;
    }

    public String toString() {
        return "ClassPojo [isDisabled = " + this.isDisabled + ", channelName = " + this.channelName + ", channelCode = " + this.channelCode + ", iconUrl = " + this.iconUrl + ", hasLowSuccess = " + this.hasLowSuccess + "]";
    }
}
