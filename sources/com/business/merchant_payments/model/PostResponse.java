package com.business.merchant_payments.model;

import com.google.gson.a.c;

public class PostResponse extends BaseModel {
    public static final long serialVersionUID = 1;
    @c(a = "bankAccountHolderName")
    public String bankAccountHolderName;
    @c(a = "bankDetailsUuid")
    public String bankDetailsUuid;
    @c(a = "displayMessage")
    public String displayMessage;
    @c(a = "internalMessage")
    public String internalMessage;
    @c(a = "nameMatchStatus")
    public boolean nameMatchStatus;
    @c(a = "refId")
    public String refId;
    @c(a = "statusCode")
    public int statusCode;

    public boolean getNameMatchStatus() {
        return this.nameMatchStatus;
    }

    public void setNameMatchStatus(boolean z) {
        this.nameMatchStatus = z;
    }

    public String getDisplayMessage() {
        return this.displayMessage;
    }

    public void setDisplayMessage(String str) {
        this.displayMessage = str;
    }

    public String getBankAccountHolderName() {
        return this.bankAccountHolderName;
    }

    public void setBankAccountHolderName(String str) {
        this.bankAccountHolderName = str;
    }

    public String getBankDetailsUuid() {
        return this.bankDetailsUuid;
    }

    public void setBankDetailsUuid(String str) {
        this.bankDetailsUuid = str;
    }

    public String getInternalMessage() {
        return this.internalMessage;
    }

    public void setInternalMessage(String str) {
        this.internalMessage = str;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public void setStatusCode(int i2) {
        this.statusCode = i2;
    }

    public String toString() {
        return "PostResponse{displayMessage = '" + this.displayMessage + '\'' + ",bankAccountHolderName = '" + this.bankAccountHolderName + '\'' + ",bankDetailsUuid = '" + this.bankDetailsUuid + '\'' + ",internalMessage = '" + this.internalMessage + '\'' + ",statusCode = '" + this.statusCode + '\'' + "}";
    }

    public String getRefId() {
        return this.refId;
    }

    public void setRefId(String str) {
        this.refId = str;
    }
}
