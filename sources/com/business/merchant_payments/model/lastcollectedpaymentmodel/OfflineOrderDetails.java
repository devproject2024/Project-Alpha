package com.business.merchant_payments.model.lastcollectedpaymentmodel;

public class OfflineOrderDetails {
    public String accountNo;
    public String bizOrderId;
    public String bizType;
    public Commission commission;
    public Commission commissionTax;
    public String extendInfo;
    public String ipRoleId;
    public String mercUnqRef;
    public String merchantOrderId;
    public String merchantReferenceId;
    public String merchantTransId;
    public String nickName;
    public String oppositeAccountNo;
    public String oppositeEmail;
    public String oppositeNickname;
    public String oppositePhone;
    public String oppositeUserId;
    public String orderCompletedTime;
    public String orderCreatedTime;
    public String orderStatus;
    public Commission payMoneyAmount;
    public String posId;
    public String reconId;
    public String referenceBizOrderId;
    public String terminalType;

    public String getBizType() {
        return this.bizType;
    }

    public void setBizType(String str) {
        this.bizType = str;
    }

    public String getMercUnqRef() {
        return this.mercUnqRef;
    }

    public void setMercUnqRef(String str) {
        this.mercUnqRef = str;
    }

    public String getOppositeEmail() {
        return this.oppositeEmail;
    }

    public void setOppositeEmail(String str) {
        this.oppositeEmail = str;
    }

    public Commission getPayMoneyAmount() {
        return this.payMoneyAmount;
    }

    public void setPayMoneyAmount(Commission commission2) {
        this.payMoneyAmount = commission2;
    }

    public String getOrderStatus() {
        return this.orderStatus;
    }

    public void setOrderStatus(String str) {
        this.orderStatus = str;
    }

    public String getOppositePhone() {
        return this.oppositePhone;
    }

    public void setOppositePhone(String str) {
        this.oppositePhone = str;
    }

    public String getMerchantOrderId() {
        return this.merchantOrderId;
    }

    public void setMerchantOrderId(String str) {
        this.merchantOrderId = str;
    }

    public String getMerchantReferenceId() {
        return this.merchantReferenceId;
    }

    public void setMerchantReferenceId(String str) {
        this.merchantReferenceId = str;
    }

    public String getReferenceBizOrderId() {
        return this.referenceBizOrderId;
    }

    public void setReferenceBizOrderId(String str) {
        this.referenceBizOrderId = str;
    }

    public String getPosId() {
        return this.posId;
    }

    public void setPosId(String str) {
        this.posId = str;
    }

    public String getOppositeUserId() {
        return this.oppositeUserId;
    }

    public void setOppositeUserId(String str) {
        this.oppositeUserId = str;
    }

    public String getAccountNo() {
        return this.accountNo;
    }

    public void setAccountNo(String str) {
        this.accountNo = str;
    }

    public String getOrderCompletedTime() {
        return this.orderCompletedTime;
    }

    public void setOrderCompletedTime(String str) {
        this.orderCompletedTime = str;
    }

    public Commission getCommission() {
        return this.commission;
    }

    public void setCommission(Commission commission2) {
        this.commission = commission2;
    }

    public String getNickName() {
        return this.nickName;
    }

    public void setNickName(String str) {
        this.nickName = str;
    }

    public String getOppositeAccountNo() {
        return this.oppositeAccountNo;
    }

    public void setOppositeAccountNo(String str) {
        this.oppositeAccountNo = str;
    }

    public String getIpRoleId() {
        return this.ipRoleId;
    }

    public void setIpRoleId(String str) {
        this.ipRoleId = str;
    }

    public String getReconId() {
        return this.reconId;
    }

    public void setReconId(String str) {
        this.reconId = str;
    }

    public String getTerminalType() {
        return this.terminalType;
    }

    public void setTerminalType(String str) {
        this.terminalType = str;
    }

    public String getBizOrderId() {
        return this.bizOrderId;
    }

    public void setBizOrderId(String str) {
        this.bizOrderId = str;
    }

    public String getMerchantTransId() {
        return this.merchantTransId;
    }

    public void setMerchantTransId(String str) {
        this.merchantTransId = str;
    }

    public Commission getCommissionTax() {
        return this.commissionTax;
    }

    public void setCommissionTax(Commission commission2) {
        this.commissionTax = commission2;
    }

    public String getOrderCreatedTime() {
        return this.orderCreatedTime;
    }

    public void setOrderCreatedTime(String str) {
        this.orderCreatedTime = str;
    }

    public String getOppositeNickname() {
        return this.oppositeNickname;
    }

    public void setOppositeNickname(String str) {
        this.oppositeNickname = str;
    }

    public void setExtendInfo(String str) {
        this.extendInfo = str;
    }

    public String getExtendInfo() {
        return this.extendInfo;
    }
}
