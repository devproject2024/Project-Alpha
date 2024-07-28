package com.travel.flight.pojo.seatancillaryentity.availability;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJRSeatTax extends IJRPaytmDataModel implements Parcelable {
    public static final Parcelable.Creator<CJRSeatTax> CREATOR = new Parcelable.Creator<CJRSeatTax>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
            return new CJRSeatTax[i2];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new CJRSeatTax(parcel);
        }
    };
    private static final long serialVersionUID = 1;
    @a
    @b(a = "chargeAmount")
    private Integer chargeAmount;
    @a
    @b(a = "chargeCode")
    private String chargeCode;

    public int describeContents() {
        return 0;
    }

    protected CJRSeatTax(Parcel parcel) {
        this.chargeCode = parcel.readString();
        if (parcel.readByte() == 0) {
            this.chargeAmount = null;
        } else {
            this.chargeAmount = Integer.valueOf(parcel.readInt());
        }
    }

    public String getChargeCode() {
        return this.chargeCode;
    }

    public void setChargeCode(String str) {
        this.chargeCode = str;
    }

    public Integer getChargeAmount() {
        return this.chargeAmount;
    }

    public void setChargeAmount(Integer num) {
        this.chargeAmount = num;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.chargeCode);
        if (this.chargeAmount == null) {
            parcel.writeByte((byte) 0);
            return;
        }
        parcel.writeByte((byte) 1);
        parcel.writeInt(this.chargeAmount.intValue());
    }
}
