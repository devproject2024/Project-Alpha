package com.business.merchant_payments.model.businesswallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.business.merchant_payments.model.BaseModel;
import java.util.List;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class OrderDetail extends BaseModel implements Parcelable {
    public static final CREATOR CREATOR = new CREATOR((g) null);
    public String custId;
    public String maskedCardNo;
    public String mercUnqRef;
    public String merchantId;
    public String merchantName;
    public String merchantPosOrderId;
    public String orderCompletedTime;
    public String orderCreatedTime;
    public String orderId;
    public String orderStatus;
    public String orderType;
    public String payMethod;
    public String prn;
    public String prnValidateTime;
    public boolean prnValidated;
    public String serviceFee;
    public List<SettlementInfo> settlementInfo;
    public String taxFee;
    public String txnAmt;
    public String txnId;
    public String userEmail;
    public String userName;
    public String userPhoneNo;
    public String userVPA;

    public final int describeContents() {
        return 0;
    }

    public OrderDetail() {
    }

    public final String getCustId() {
        return this.custId;
    }

    public final void setCustId(String str) {
        this.custId = str;
    }

    public final String getMercUnqRef() {
        return this.mercUnqRef;
    }

    public final void setMercUnqRef(String str) {
        this.mercUnqRef = str;
    }

    public final String getMerchantId() {
        return this.merchantId;
    }

    public final void setMerchantId(String str) {
        this.merchantId = str;
    }

    public final String getMerchantName() {
        return this.merchantName;
    }

    public final void setMerchantName(String str) {
        this.merchantName = str;
    }

    public final String getMerchantPosOrderId() {
        return this.merchantPosOrderId;
    }

    public final void setMerchantPosOrderId(String str) {
        this.merchantPosOrderId = str;
    }

    public final String getOrderCompletedTime() {
        return this.orderCompletedTime;
    }

    public final void setOrderCompletedTime(String str) {
        this.orderCompletedTime = str;
    }

    public final String getOrderCreatedTime() {
        return this.orderCreatedTime;
    }

    public final void setOrderCreatedTime(String str) {
        this.orderCreatedTime = str;
    }

    public final String getOrderId() {
        return this.orderId;
    }

    public final void setOrderId(String str) {
        this.orderId = str;
    }

    public final String getOrderStatus() {
        return this.orderStatus;
    }

    public final void setOrderStatus(String str) {
        this.orderStatus = str;
    }

    public final String getOrderType() {
        return this.orderType;
    }

    public final void setOrderType(String str) {
        this.orderType = str;
    }

    public final String getPrn() {
        return this.prn;
    }

    public final void setPrn(String str) {
        this.prn = str;
    }

    public final String getPrnValidateTime() {
        return this.prnValidateTime;
    }

    public final void setPrnValidateTime(String str) {
        this.prnValidateTime = str;
    }

    public final boolean getPrnValidated() {
        return this.prnValidated;
    }

    public final void setPrnValidated(boolean z) {
        this.prnValidated = z;
    }

    public final String getServiceFee() {
        return this.serviceFee;
    }

    public final void setServiceFee(String str) {
        this.serviceFee = str;
    }

    public final List<SettlementInfo> getSettlementInfo() {
        return this.settlementInfo;
    }

    public final void setSettlementInfo(List<SettlementInfo> list) {
        this.settlementInfo = list;
    }

    public final String getTaxFee() {
        return this.taxFee;
    }

    public final void setTaxFee(String str) {
        this.taxFee = str;
    }

    public final String getTxnAmt() {
        return this.txnAmt;
    }

    public final void setTxnAmt(String str) {
        this.txnAmt = str;
    }

    public final String getTxnId() {
        return this.txnId;
    }

    public final void setTxnId(String str) {
        this.txnId = str;
    }

    public final String getUserEmail() {
        return this.userEmail;
    }

    public final void setUserEmail(String str) {
        this.userEmail = str;
    }

    public final String getUserPhoneNo() {
        return this.userPhoneNo;
    }

    public final void setUserPhoneNo(String str) {
        this.userPhoneNo = str;
    }

    public final String getUserVPA() {
        return this.userVPA;
    }

    public final void setUserVPA(String str) {
        this.userVPA = str;
    }

    public final String getMaskedCardNo() {
        return this.maskedCardNo;
    }

    public final void setMaskedCardNo(String str) {
        this.maskedCardNo = str;
    }

    public final String getPayMethod() {
        return this.payMethod;
    }

    public final void setPayMethod(String str) {
        this.payMethod = str;
    }

    public final String getUserName() {
        return this.userName;
    }

    public final void setUserName(String str) {
        this.userName = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public OrderDetail(Parcel parcel) {
        this();
        k.d(parcel, "parcel");
        this.custId = parcel.readString();
        this.mercUnqRef = parcel.readString();
        this.merchantId = parcel.readString();
        this.merchantName = parcel.readString();
        this.merchantPosOrderId = parcel.readString();
        this.orderCompletedTime = parcel.readString();
        this.orderCreatedTime = parcel.readString();
        this.orderId = parcel.readString();
        this.orderStatus = parcel.readString();
        this.orderType = parcel.readString();
        this.prn = parcel.readString();
        this.prnValidateTime = parcel.readString();
        this.prnValidated = parcel.readByte() != 0;
        this.serviceFee = parcel.readString();
        this.settlementInfo = parcel.createTypedArrayList(SettlementInfo.CREATOR);
        this.taxFee = parcel.readString();
        this.txnAmt = parcel.readString();
        this.txnId = parcel.readString();
        this.userEmail = parcel.readString();
        this.userPhoneNo = parcel.readString();
        this.userVPA = parcel.readString();
        this.userName = parcel.readString();
        this.maskedCardNo = parcel.readString();
        this.payMethod = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        k.d(parcel, "parcel");
        parcel.writeString(this.custId);
        parcel.writeString(this.mercUnqRef);
        parcel.writeString(this.merchantId);
        parcel.writeString(this.merchantName);
        parcel.writeString(this.merchantPosOrderId);
        parcel.writeString(this.orderCompletedTime);
        parcel.writeString(this.orderCreatedTime);
        parcel.writeString(this.orderId);
        parcel.writeString(this.orderStatus);
        parcel.writeString(this.orderType);
        parcel.writeString(this.prn);
        parcel.writeString(this.prnValidateTime);
        parcel.writeByte(this.prnValidated ? (byte) 1 : 0);
        parcel.writeString(this.serviceFee);
        parcel.writeTypedList(this.settlementInfo);
        parcel.writeString(this.taxFee);
        parcel.writeString(this.txnAmt);
        parcel.writeString(this.txnId);
        parcel.writeString(this.userEmail);
        parcel.writeString(this.userPhoneNo);
        parcel.writeString(this.userVPA);
        parcel.writeString(this.userName);
        parcel.writeString(this.maskedCardNo);
        parcel.writeString(this.payMethod);
    }

    public static final class CREATOR implements Parcelable.Creator<OrderDetail> {
        public CREATOR() {
        }

        public /* synthetic */ CREATOR(g gVar) {
            this();
        }

        public final OrderDetail createFromParcel(Parcel parcel) {
            k.d(parcel, "parcel");
            return new OrderDetail(parcel);
        }

        public final OrderDetail[] newArray(int i2) {
            return new OrderDetail[i2];
        }
    }
}
