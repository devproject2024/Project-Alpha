package com.travel.flight.pojo.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.a.c;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;

public class CJRSeatSelection extends IJRPaytmDataModel implements Parcelable {
    public static final Parcelable.Creator<CJRSeatSelection> CREATOR = new Parcelable.Creator<CJRSeatSelection>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
            return new CJRSeatSelection[i2];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new CJRSeatSelection(parcel);
        }
    };
    @c(a = "destination")
    private String mDestination;
    @c(a = "flight_number")
    private String mFlightNumber;
    @c(a = "origin")
    private String mOrigin;
    @c(a = "items")
    private ArrayList<CJRSeatSelectedItem> mSeatSelectedItems;
    private int mSelectedSeatsCount;
    private double mTotalSeatPrice;

    public int describeContents() {
        return 0;
    }

    public CJRSeatSelection() {
    }

    protected CJRSeatSelection(Parcel parcel) {
        this.mSelectedSeatsCount = parcel.readInt();
        this.mFlightNumber = parcel.readString();
        this.mOrigin = parcel.readString();
        this.mDestination = parcel.readString();
        this.mSeatSelectedItems = new ArrayList<>();
        this.mSeatSelectedItems = parcel.readArrayList(CJRSeatSelectedItem.class.getClassLoader());
        this.mTotalSeatPrice = parcel.readDouble();
    }

    public String getmFlightNumber() {
        return this.mFlightNumber;
    }

    public void setmFlightNumber(String str) {
        this.mFlightNumber = str;
    }

    public String getmOrigin() {
        return this.mOrigin;
    }

    public void setmOrigin(String str) {
        this.mOrigin = str;
    }

    public String getmDestination() {
        return this.mDestination;
    }

    public void setmDestination(String str) {
        this.mDestination = str;
    }

    public ArrayList<CJRSeatSelectedItem> getmSeatSelectedItems() {
        return this.mSeatSelectedItems;
    }

    public void setmSeatSelectedItems(ArrayList<CJRSeatSelectedItem> arrayList) {
        this.mSeatSelectedItems = arrayList;
    }

    public int getmSelectedSeatsCount() {
        return this.mSelectedSeatsCount;
    }

    public void setmSelectedSeatsCount(int i2) {
        this.mSelectedSeatsCount = i2;
    }

    public double getmTotalSeatPrice() {
        return this.mTotalSeatPrice;
    }

    public void setmTotalSeatPrice(double d2) {
        this.mTotalSeatPrice = d2;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.mSelectedSeatsCount);
        parcel.writeString(this.mFlightNumber);
        parcel.writeString(this.mOrigin);
        parcel.writeString(this.mDestination);
        parcel.writeList(this.mSeatSelectedItems);
        parcel.writeDouble(this.mTotalSeatPrice);
    }
}
