package net.one97.paytm.nativesdk.bank_mandate.dataModel;

import com.google.gson.a.c;
import java.io.Serializable;
import java.util.List;

public class SavedMandateBanksItem implements Serializable {
    @c(a = "accRefId")
    private String accRefId;
    @c(a = "accountHolderName")
    private String accountHolderName;
    @c(a = "accountType")
    private String accountType;
    @c(a = "channelCode")
    private String channelCode;
    @c(a = "channelName")
    private String channelName;
    @c(a = "displayName")
    private String displayName;
    @c(a = "iconUrl")
    private String iconUrl;
    @c(a = "ifsc")
    private String ifsc;
    @c(a = "isHybridDisabled")
    private boolean isHybridDisabled;
    @c(a = "mandateAuthMode")
    private List<String> mandateAuthMode;
    @c(a = "mandateBankCode")
    private String mandateBankCode;
    @c(a = "mandateMode")
    private String mandateMode;
    @c(a = "maskedAccountNumber")
    private String maskedAccountNumber;
    @c(a = "priority")
    private String priority;

    public String getPriority() {
        return this.priority;
    }

    public void setPriority(String str) {
        this.priority = str;
    }

    public void setMandateMode(String str) {
        this.mandateMode = str;
    }

    public String getMandateMode() {
        return this.mandateMode;
    }

    public void setMandateAuthMode(List<String> list) {
        this.mandateAuthMode = list;
    }

    public List<String> getMandateAuthMode() {
        return this.mandateAuthMode;
    }

    public void setMandateBankCode(String str) {
        this.mandateBankCode = str;
    }

    public String getMandateBankCode() {
        return this.mandateBankCode;
    }

    public void setAccountHolderName(String str) {
        this.accountHolderName = str;
    }

    public String getAccountHolderName() {
        return this.accountHolderName;
    }

    public void setMaskedAccountNumber(String str) {
        this.maskedAccountNumber = str;
    }

    public String getMaskedAccountNumber() {
        return this.maskedAccountNumber;
    }

    public void setAccountType(String str) {
        this.accountType = str;
    }

    public String getAccountType() {
        return this.accountType;
    }

    public void setAccRefId(String str) {
        this.accRefId = str;
    }

    public String getAccRefId() {
        return this.accRefId;
    }

    public void setDisplayName(String str) {
        this.displayName = str;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public void setIfsc(String str) {
        this.ifsc = str;
    }

    public String getIfsc() {
        return this.ifsc;
    }

    public void setIsHybridDisabled(boolean z) {
        this.isHybridDisabled = z;
    }

    public boolean isIsHybridDisabled() {
        return this.isHybridDisabled;
    }

    public void setChannelCode(String str) {
        this.channelCode = str;
    }

    public String getChannelCode() {
        return this.channelCode;
    }

    public void setChannelName(String str) {
        this.channelName = str;
    }

    public String getChannelName() {
        return this.channelName;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public void setIconUrl(String str) {
        this.iconUrl = str;
    }

    public String toString() {
        return "SavedMandateBanksItem{mandateMode = '" + this.mandateMode + '\'' + ",mandateAuthMode = '" + this.mandateAuthMode + '\'' + ",mandateBankCode = '" + this.mandateBankCode + '\'' + ",accountHolderName = '" + this.accountHolderName + '\'' + ",maskedAccountNumber = '" + this.maskedAccountNumber + '\'' + ",accountType = '" + this.accountType + '\'' + ",accRefId = '" + this.accRefId + '\'' + ",displayName = '" + this.displayName + '\'' + ",ifsc = '" + this.ifsc + '\'' + ",isHybridDisabled = '" + this.isHybridDisabled + '\'' + ",channelCode = '" + this.channelCode + '\'' + ",channelName = '" + this.channelName + '\'' + "}";
    }
}
