package com.travel.citybus.brts.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRBrtsPaxInfo implements Parcelable, IJRDataModel {
    public static final Parcelable.Creator<CJRBrtsPaxInfo> CREATOR = new Parcelable.Creator<CJRBrtsPaxInfo>() {
        public final CJRBrtsPaxInfo createFromParcel(Parcel parcel) {
            return new CJRBrtsPaxInfo();
        }

        public final CJRBrtsPaxInfo[] newArray(int i2) {
            return new CJRBrtsPaxInfo[i2];
        }
    };
    private static final long serialVersionUID = 1;
    @b(a = "count")
    private int count;
    @b(a = "fare")
    private double mFare;
    @b(a = "pax")
    private String mPaxName;
    @b(a = "pax_type")
    private String mPaxType;
    @b(a = "value")
    private double mValue;

    public int describeContents() {
        return 0;
    }

    public String getPaxName() {
        String str = this.mPaxName;
        if (str != null) {
            return str;
        }
        return this.mPaxType;
    }

    public double getFare() {
        double d2 = this.mFare;
        if (d2 != 0.0d) {
            return d2;
        }
        double d3 = this.mValue;
        if (d3 != 0.0d) {
            return d3;
        }
        return 0.0d;
    }

    public int getCount() {
        return this.count;
    }

    public void setCount(int i2) {
        this.count = i2;
    }

    public void setmPaxName(String str) {
        this.mPaxName = str;
    }

    public void setmFare(double d2) {
        this.mFare = d2;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.mPaxName);
        parcel.writeString(this.mPaxType);
        parcel.writeDouble(this.mValue);
        parcel.writeDouble(this.mFare);
        parcel.writeInt(this.count);
    }

    private void readFromParcel(Parcel parcel) {
        this.mPaxName = parcel.readString();
        this.mPaxType = parcel.readString();
        this.mValue = parcel.readDouble();
        this.mFare = parcel.readDouble();
        this.count = parcel.readInt();
    }
}
