package net.one97.paytm.nativesdk.bank_mandate.dataModel;

import com.google.gson.a.c;
import java.io.Serializable;
import java.util.List;

public class MandateAccountDetails implements Serializable {
    @c(a = "accountHolderName")
    private String accountHolderName;
    @c(a = "accountNumber")
    private String accountNumber;
    @c(a = "accountType")
    private String accountType;
    @c(a = "channelCode")
    private String channelCode;
    @c(a = "channelName")
    private String channelName;
    @c(a = "iconUrl")
    private String iconUrl;
    @c(a = "ifsc")
    private String ifsc;
    @c(a = "mandateAuthMode")
    private List<String> mandateAuthMode;

    public void setAccountHolderName(String str) {
        this.accountHolderName = str;
    }

    public String getAccountHolderName() {
        return this.accountHolderName;
    }

    public void setAccountNumber(String str) {
        this.accountNumber = str;
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public void setIfsc(String str) {
        this.ifsc = str;
    }

    public String getIfsc() {
        return this.ifsc;
    }

    public void setAccountType(String str) {
        this.accountType = str;
    }

    public String getAccountType() {
        return this.accountType;
    }

    public void setIconUrl(String str) {
        this.iconUrl = str;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public void setMandateAuthMode(List<String> list) {
        this.mandateAuthMode = list;
    }

    public List<String> getMandateAuthMode() {
        return this.mandateAuthMode;
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

    public String toString() {
        return "MandateAccountDetails{accountHolderName = '" + this.accountHolderName + '\'' + ",accountNumber = '" + this.accountNumber + '\'' + ",ifsc = '" + this.ifsc + '\'' + ",accountType = '" + this.accountType + '\'' + ",iconUrl = '" + this.iconUrl + '\'' + ",mandateAuthMode = '" + this.mandateAuthMode + '\'' + ",channelCode = '" + this.channelCode + '\'' + ",channelName = '" + this.channelName + '\'' + "}";
    }
}
