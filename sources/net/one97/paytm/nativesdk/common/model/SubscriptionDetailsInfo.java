package net.one97.paytm.nativesdk.common.model;

import com.google.gson.a.c;
import java.util.List;

public class SubscriptionDetailsInfo implements BaseDataModel {
    @c(a = "amount")
    private String amount;
    @c(a = "details")
    private Details details;
    private String endDate;
    private String infoMessage;
    private List<Object> infoMessageList = null;
    private boolean isEnabled;
    private String maxAmount;
    private boolean nonSpecificPayMode;
    private String renewMessage;
    private boolean saveCardMandatoryAddNPay;
    private boolean showDetails;
    private String startDate;
    private String subsId;
    @c(a = "subsMaxAmount")
    private String subsMaxAmount;
    private String subsType;
    private String subscriptionPurpose;
    private String subsfrequency;

    public String getSubsMaxAmount() {
        return this.subsMaxAmount;
    }

    public void setSubsMaxAmount(String str) {
        this.subsMaxAmount = str;
    }

    public String getSubsType() {
        return this.subsType;
    }

    public void setSubsType(String str) {
        this.subsType = str;
    }

    public String getSubsId() {
        return this.subsId;
    }

    public void setSubsId(String str) {
        this.subsId = str;
    }

    public String getRenewMessage() {
        return this.renewMessage;
    }

    public void setRenewMessage(String str) {
        this.renewMessage = str;
    }

    public boolean isSaveCardMandatoryAddNPay() {
        return this.saveCardMandatoryAddNPay;
    }

    public void setSaveCardMandatoryAddNPay(boolean z) {
        this.saveCardMandatoryAddNPay = z;
    }

    public boolean isNonSpecificPayMode() {
        return this.nonSpecificPayMode;
    }

    public void setNonSpecificPayMode(boolean z) {
        this.nonSpecificPayMode = z;
    }

    public String getAmount() {
        return this.amount;
    }

    public void setAmount(String str) {
        this.amount = str;
    }

    public String getInfoMessage() {
        return this.infoMessage;
    }

    public void setInfoMessage(String str) {
        this.infoMessage = str;
    }

    public boolean isShowDetails() {
        return this.showDetails;
    }

    public void setShowDetails(boolean z) {
        this.showDetails = z;
    }

    public Details getDetails() {
        return this.details;
    }

    public void setDetails(Details details2) {
        this.details = details2;
    }

    public boolean isIsEnabled() {
        return this.isEnabled;
    }

    public void setIsEnabled(boolean z) {
        this.isEnabled = z;
    }

    public List<Object> getInfoMessageList() {
        return this.infoMessageList;
    }

    public void setInfoMessageList(List<Object> list) {
        this.infoMessageList = list;
    }

    public String getSubscriptionPurpose() {
        return this.subscriptionPurpose;
    }

    public void setSubscriptionPurpose(String str) {
        this.subscriptionPurpose = str;
    }

    public String getStartDate() {
        return this.startDate;
    }

    public void setStartDate(String str) {
        this.startDate = str;
    }

    public String getEndDate() {
        return this.endDate;
    }

    public void setEndDate(String str) {
        this.endDate = str;
    }

    public String getMaxAmount() {
        return this.maxAmount;
    }

    public void setMaxAmount(String str) {
        this.maxAmount = str;
    }

    public String getSubsfrequency() {
        return this.subsfrequency;
    }

    public void setSubsfrequency(String str) {
        this.subsfrequency = str;
    }
}
