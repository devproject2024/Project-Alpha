package com.business.merchant_payments.payment.model.orderDetail;

import com.business.merchant_payments.model.BaseModel;
import com.google.gson.a.a;
import com.google.gson.a.c;
import java.io.Serializable;

public final class OrderDetail extends BaseModel implements Serializable {
    @c(a = "additionalInfo")
    @a
    public AdditionalInfo additionalInfo;
    @c(a = "bizOrderId")
    @a
    public String bizOrderId;
    @c(a = "bizType")
    @a
    public String bizType;
    @c(a = "cashPosIncentiveAmount")
    public PayMoneyAmount cashPosIncentiveAmount;
    @c(a = "commission")
    @a
    public Commission commission;
    @c(a = "commissionTax")
    @a
    public CommissionTax commissionTax;
    @c(a = "ipRoleId")
    @a
    public String ipRoleId;
    @c(a = "loginId")
    @a
    public String loginId;
    @c(a = "mMaskedCardNo")
    @a
    public String mMaskedCardNo;
    @c(a = "mPayMode")
    @a
    public String mPayMode;
    @c(a = "mUpiId")
    @a
    public String mUpiId;
    @c(a = "mercUnqRef")
    @a
    public String mercUnqRef;
    @c(a = "merchantTransId")
    @a
    public String merchantTransId;
    @c(a = "nickName")
    @a
    public String nickName;
    @c(a = "oppositeEmail")
    @a
    public String oppositeEmail;
    @c(a = "oppositeNickname")
    @a
    public String oppositeNickname;
    @c(a = "oppositePhone")
    @a
    public String oppositePhone;
    @c(a = "oppositeUserId")
    @a
    public String oppositeUserId;
    @c(a = "orderCompletedTime")
    @a
    public String orderCompletedTime;
    @c(a = "orderCreatedTime")
    @a
    public String orderCreatedTime;
    @c(a = "orderStatus")
    @a
    public String orderStatus;
    @c(a = "payMoneyAmount")
    @a
    public PayMoneyAmount payMoneyAmount;
    @c(a = "productCode")
    @a
    public String productCode;
    @c(a = "referenceBizOrderId")
    @a
    public String referenceBizOrderId;
    @c(a = "terminalType")
    @a
    public String terminalType;
    @c(a = "txnSettleType")
    @a
    public String txnSettleType;

    public final String getBizOrderId() {
        return this.bizOrderId;
    }

    public final void setBizOrderId(String str) {
        this.bizOrderId = str;
    }

    public final String getReferenceBizOrderId() {
        return this.referenceBizOrderId;
    }

    public final void setReferenceBizOrderId(String str) {
        this.referenceBizOrderId = str;
    }

    public final String getMerchantTransId() {
        return this.merchantTransId;
    }

    public final void setMerchantTransId(String str) {
        this.merchantTransId = str;
    }

    public final String getMercUnqRef() {
        return this.mercUnqRef;
    }

    public final void setMercUnqRef(String str) {
        this.mercUnqRef = str;
    }

    public final String getOrderCreatedTime() {
        return this.orderCreatedTime;
    }

    public final void setOrderCreatedTime(String str) {
        this.orderCreatedTime = str;
    }

    public final String getOrderCompletedTime() {
        return this.orderCompletedTime;
    }

    public final void setOrderCompletedTime(String str) {
        this.orderCompletedTime = str;
    }

    public final String getTxnSettleType() {
        return this.txnSettleType;
    }

    public final void setTxnSettleType(String str) {
        this.txnSettleType = str;
    }

    public final String getBizType() {
        return this.bizType;
    }

    public final void setBizType(String str) {
        this.bizType = str;
    }

    public final String getOrderStatus() {
        return this.orderStatus;
    }

    public final void setOrderStatus(String str) {
        this.orderStatus = str;
    }

    public final String getIpRoleId() {
        return this.ipRoleId;
    }

    public final void setIpRoleId(String str) {
        this.ipRoleId = str;
    }

    public final String getNickName() {
        return this.nickName;
    }

    public final void setNickName(String str) {
        this.nickName = str;
    }

    public final String getOppositeUserId() {
        return this.oppositeUserId;
    }

    public final void setOppositeUserId(String str) {
        this.oppositeUserId = str;
    }

    public final String getOppositeNickname() {
        return this.oppositeNickname;
    }

    public final void setOppositeNickname(String str) {
        this.oppositeNickname = str;
    }

    public final String getOppositePhone() {
        return this.oppositePhone;
    }

    public final void setOppositePhone(String str) {
        this.oppositePhone = str;
    }

    public final PayMoneyAmount getPayMoneyAmount() {
        return this.payMoneyAmount;
    }

    public final void setPayMoneyAmount(PayMoneyAmount payMoneyAmount2) {
        this.payMoneyAmount = payMoneyAmount2;
    }

    public final Commission getCommission() {
        return this.commission;
    }

    public final void setCommission(Commission commission2) {
        this.commission = commission2;
    }

    public final CommissionTax getCommissionTax() {
        return this.commissionTax;
    }

    public final void setCommissionTax(CommissionTax commissionTax2) {
        this.commissionTax = commissionTax2;
    }

    public final AdditionalInfo getAdditionalInfo() {
        return this.additionalInfo;
    }

    public final void setAdditionalInfo(AdditionalInfo additionalInfo2) {
        this.additionalInfo = additionalInfo2;
    }

    public final String getTerminalType() {
        return this.terminalType;
    }

    public final void setTerminalType(String str) {
        this.terminalType = str;
    }

    public final String getLoginId() {
        return this.loginId;
    }

    public final void setLoginId(String str) {
        this.loginId = str;
    }

    public final String getOppositeEmail() {
        return this.oppositeEmail;
    }

    public final void setOppositeEmail(String str) {
        this.oppositeEmail = str;
    }

    public final String getMPayMode() {
        return this.mPayMode;
    }

    public final void setMPayMode(String str) {
        this.mPayMode = str;
    }

    public final String getMUpiId() {
        return this.mUpiId;
    }

    public final void setMUpiId(String str) {
        this.mUpiId = str;
    }

    public final String getMMaskedCardNo() {
        return this.mMaskedCardNo;
    }

    public final void setMMaskedCardNo(String str) {
        this.mMaskedCardNo = str;
    }

    public final PayMoneyAmount getCashPosIncentiveAmount() {
        return this.cashPosIncentiveAmount;
    }

    public final void setCashPosIncentiveAmount(PayMoneyAmount payMoneyAmount2) {
        this.cashPosIncentiveAmount = payMoneyAmount2;
    }

    public final String getProductCode() {
        return this.productCode;
    }

    public final void setProductCode(String str) {
        this.productCode = str;
    }
}
