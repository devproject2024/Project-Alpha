package com.business.merchant_payments.model.businesswallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.business.merchant_payments.model.BaseModel;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class OrdersItem extends BaseModel implements Parcelable {
    public static final CREATOR CREATOR = new CREATOR((g) null);
    public String accountNo;
    public String inOut;
    public String maskedCardNo;
    public String mercUnqRef;
    public String merchantId;
    public String merchantName;
    public String merchantPosOrderId;
    public String oppositeAccountNo;
    public String orderCompletedTime;
    public String orderCreatedTime;
    public String orderId;
    public String orderStatus;
    public String orderType;
    public String payMethod;
    public String prn;
    public String prnValidateTime;
    public boolean prnValidated;
    public String reconId;
    public transient boolean showEntryAnimation;
    public String txnAmt;
    public String txnId;
    public String userEmail;
    public String userName;
    public String userPhoneNo;
    public String userVPA;

    public final int describeContents() {
        return 0;
    }

    public OrdersItem() {
    }

    public final String getOrderType() {
        return this.orderType;
    }

    public final void setOrderType(String str) {
        this.orderType = str;
    }

    public final String getPrnValidateTime() {
        return this.prnValidateTime;
    }

    public final void setPrnValidateTime(String str) {
        this.prnValidateTime = str;
    }

    public final String getOrderId() {
        return this.orderId;
    }

    public final void setOrderId(String str) {
        this.orderId = str;
    }

    public final String getMercUnqRef() {
        return this.mercUnqRef;
    }

    public final void setMercUnqRef(String str) {
        this.mercUnqRef = str;
    }

    public final String getUserPhoneNo() {
        return this.userPhoneNo;
    }

    public final void setUserPhoneNo(String str) {
        this.userPhoneNo = str;
    }

    public final boolean getPrnValidated() {
        return this.prnValidated;
    }

    public final void setPrnValidated(boolean z) {
        this.prnValidated = z;
    }

    public final String getOrderStatus() {
        return this.orderStatus;
    }

    public final void setOrderStatus(String str) {
        this.orderStatus = str;
    }

    public final String getPrn() {
        return this.prn;
    }

    public final void setPrn(String str) {
        this.prn = str;
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

    public final String getMerchantId() {
        return this.merchantId;
    }

    public final void setMerchantId(String str) {
        this.merchantId = str;
    }

    public final String getOrderCompletedTime() {
        return this.orderCompletedTime;
    }

    public final void setOrderCompletedTime(String str) {
        this.orderCompletedTime = str;
    }

    public final String getUserEmail() {
        return this.userEmail;
    }

    public final void setUserEmail(String str) {
        this.userEmail = str;
    }

    public final String getOrderCreatedTime() {
        return this.orderCreatedTime;
    }

    public final void setOrderCreatedTime(String str) {
        this.orderCreatedTime = str;
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

    public final String getInOut() {
        return this.inOut;
    }

    public final void setInOut(String str) {
        this.inOut = str;
    }

    public final String getOppositeAccountNo() {
        return this.oppositeAccountNo;
    }

    public final void setOppositeAccountNo(String str) {
        this.oppositeAccountNo = str;
    }

    public final String getReconId() {
        return this.reconId;
    }

    public final void setReconId(String str) {
        this.reconId = str;
    }

    public final String getAccountNo() {
        return this.accountNo;
    }

    public final void setAccountNo(String str) {
        this.accountNo = str;
    }

    public final String getUserName() {
        return this.userName;
    }

    public final void setUserName(String str) {
        this.userName = str;
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

    public final boolean getShowEntryAnimation() {
        return this.showEntryAnimation;
    }

    public final void setShowEntryAnimation(boolean z) {
        this.showEntryAnimation = z;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public OrdersItem(Parcel parcel) {
        this();
        k.d(parcel, "parcel");
        this.orderType = parcel.readString();
        this.prnValidateTime = parcel.readString();
        this.orderId = parcel.readString();
        this.mercUnqRef = parcel.readString();
        this.userPhoneNo = parcel.readString();
        this.prnValidated = parcel.readByte() != 0;
        this.orderStatus = parcel.readString();
        this.prn = parcel.readString();
        this.merchantName = parcel.readString();
        this.merchantPosOrderId = parcel.readString();
        this.merchantId = parcel.readString();
        this.orderCompletedTime = parcel.readString();
        this.userEmail = parcel.readString();
        this.orderCreatedTime = parcel.readString();
        this.txnAmt = parcel.readString();
        this.txnId = parcel.readString();
        this.inOut = parcel.readString();
        this.oppositeAccountNo = parcel.readString();
        this.reconId = parcel.readString();
        this.accountNo = parcel.readString();
        this.userName = parcel.readString();
        this.userVPA = parcel.readString();
        this.maskedCardNo = parcel.readString();
        this.payMethod = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        k.d(parcel, "parcel");
        parcel.writeString(this.orderType);
        parcel.writeString(this.prnValidateTime);
        parcel.writeString(this.orderId);
        parcel.writeString(this.mercUnqRef);
        parcel.writeString(this.userPhoneNo);
        parcel.writeByte(this.prnValidated ? (byte) 1 : 0);
        parcel.writeString(this.orderStatus);
        parcel.writeString(this.prn);
        parcel.writeString(this.merchantName);
        parcel.writeString(this.merchantPosOrderId);
        parcel.writeString(this.merchantId);
        parcel.writeString(this.orderCompletedTime);
        parcel.writeString(this.userEmail);
        parcel.writeString(this.orderCreatedTime);
        parcel.writeString(this.txnAmt);
        parcel.writeString(this.txnId);
        parcel.writeString(this.inOut);
        parcel.writeString(this.oppositeAccountNo);
        parcel.writeString(this.reconId);
        parcel.writeString(this.accountNo);
        parcel.writeString(this.userName);
        parcel.writeString(this.userVPA);
        parcel.writeString(this.maskedCardNo);
        parcel.writeString(this.payMethod);
    }

    public final String toString() {
        return "OrdersItem(orderType=" + this.orderType + ", orderId=" + this.orderId + ", orderStatus=" + this.orderStatus + ',' + " merchantName=" + this.merchantName + ", merchantId=" + this.merchantId + ',' + " orderCreatedTime=" + this.orderCreatedTime + ", txnAmt=" + this.txnAmt + ',' + " txnId=" + this.txnId + ", reconId=" + this.reconId + ", userName=" + this.userName + ", userVPA=" + this.userVPA + ')';
    }

    public static final class CREATOR implements Parcelable.Creator<OrdersItem> {
        public CREATOR() {
        }

        public /* synthetic */ CREATOR(g gVar) {
            this();
        }

        public final OrdersItem createFromParcel(Parcel parcel) {
            k.d(parcel, "parcel");
            return new OrdersItem(parcel);
        }

        public final OrdersItem[] newArray(int i2) {
            return new OrdersItem[i2];
        }
    }
}
