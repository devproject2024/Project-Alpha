package com.business.merchant_payments.model.businesswallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.business.merchant_payments.model.BaseModel;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class SettlementInfo extends BaseModel implements Parcelable {
    public static final CREATOR CREATOR = new CREATOR((g) null);
    public String paymentAmt;
    public String payoutId;
    public String serviceFee;
    public String settledAmt;
    public String settlementTime;
    public String taxFee;
    public String utrNo;

    public final int describeContents() {
        return 0;
    }

    public SettlementInfo() {
    }

    public final String getPaymentAmt() {
        return this.paymentAmt;
    }

    public final void setPaymentAmt(String str) {
        this.paymentAmt = str;
    }

    public final String getPayoutId() {
        return this.payoutId;
    }

    public final void setPayoutId(String str) {
        this.payoutId = str;
    }

    public final String getServiceFee() {
        return this.serviceFee;
    }

    public final void setServiceFee(String str) {
        this.serviceFee = str;
    }

    public final String getSettledAmt() {
        return this.settledAmt;
    }

    public final void setSettledAmt(String str) {
        this.settledAmt = str;
    }

    public final String getSettlementTime() {
        return this.settlementTime;
    }

    public final void setSettlementTime(String str) {
        this.settlementTime = str;
    }

    public final String getTaxFee() {
        return this.taxFee;
    }

    public final void setTaxFee(String str) {
        this.taxFee = str;
    }

    public final String getUtrNo() {
        return this.utrNo;
    }

    public final void setUtrNo(String str) {
        this.utrNo = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SettlementInfo(Parcel parcel) {
        this();
        k.d(parcel, "parcel");
        this.paymentAmt = parcel.readString();
        this.payoutId = parcel.readString();
        this.serviceFee = parcel.readString();
        this.settledAmt = parcel.readString();
        this.settlementTime = parcel.readString();
        this.taxFee = parcel.readString();
        this.utrNo = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        k.d(parcel, "parcel");
        parcel.writeString(this.paymentAmt);
        parcel.writeString(this.payoutId);
        parcel.writeString(this.serviceFee);
        parcel.writeString(this.settledAmt);
        parcel.writeString(this.settlementTime);
        parcel.writeString(this.taxFee);
        parcel.writeString(this.utrNo);
    }

    public static final class CREATOR implements Parcelable.Creator<SettlementInfo> {
        public CREATOR() {
        }

        public /* synthetic */ CREATOR(g gVar) {
            this();
        }

        public final SettlementInfo createFromParcel(Parcel parcel) {
            k.d(parcel, "parcel");
            return new SettlementInfo(parcel);
        }

        public final SettlementInfo[] newArray(int i2) {
            return new SettlementInfo[i2];
        }
    }
}
