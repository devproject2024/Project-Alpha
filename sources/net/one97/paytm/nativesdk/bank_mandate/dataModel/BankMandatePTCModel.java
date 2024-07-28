package net.one97.paytm.nativesdk.bank_mandate.dataModel;

import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;

public class BankMandatePTCModel {
    String accountHolderName;
    String accountNumber;
    String accountType;
    String bankIfsc;
    String channelCode;
    String mandateAuthMode;
    String paymentMode;
    String subsId;
    String upiAccRefId;
    String userName;

    public String getUpiAccRefId() {
        return this.upiAccRefId;
    }

    public void setUpiAccRefId(String str) {
        this.upiAccRefId = str;
    }

    public String getSubsId() {
        return this.subsId;
    }

    public void setSubsId(String str) {
        this.subsId = str;
    }

    public String getMandateAuthMode() {
        return this.mandateAuthMode;
    }

    public void setMandateAuthMode(String str) {
        this.mandateAuthMode = str;
    }

    public String getBankIfsc() {
        return this.bankIfsc;
    }

    public void setBankIfsc(String str) {
        this.bankIfsc = str;
    }

    public String getPaymentMode() {
        return this.paymentMode;
    }

    public void setPaymentMode(String str) {
        this.paymentMode = str;
    }

    public String getChannelCode() {
        return this.channelCode;
    }

    public void setChannelCode(String str) {
        this.channelCode = str;
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public void setAccountNumber(String str) {
        this.accountNumber = str;
    }

    public String getAccountType() {
        return this.accountType;
    }

    public void setAccountType(String str) {
        this.accountType = str;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String str) {
        this.userName = str;
    }

    public String getAccountHolderName() {
        return this.accountHolderName;
    }

    public void setAccountHolderName(String str) {
        this.accountHolderName = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Bank Mandate PTC Value");
        sb.append(this.mandateAuthMode);
        sb.append(this.bankIfsc);
        sb.append(AppConstants.COLON);
        sb.append(this.paymentMode);
        sb.append(AppConstants.COLON);
        sb.append(this.accountType);
        sb.append(AppConstants.COLON);
        sb.append(this.channelCode);
        sb.append(AppConstants.COLON);
        sb.append(this.accountNumber);
        sb.append(AppConstants.COLON);
        sb.append(this.userName);
        sb.append(AppConstants.COLON);
        sb.append(this.accountHolderName);
        return super.toString();
    }
}
