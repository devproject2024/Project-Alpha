package com.travel.flight.pojo.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.a.c;
import com.paytm.network.model.IJRPaytmDataModel;
import com.travel.flight.pojo.seatancillaryentity.availability.CJRSeatTax;
import java.util.ArrayList;
import java.util.List;

public class CJRSeatSelectedItem extends IJRPaytmDataModel implements Parcelable {
    public static final Parcelable.Creator<CJRSeatSelectedItem> CREATOR = new Parcelable.Creator<CJRSeatSelectedItem>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
            return new CJRSeatSelectedItem[i2];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new CJRSeatSelectedItem(parcel);
        }
    };
    private boolean isSeatSelected;
    private List<CJRSeatTax> mCJRSeatTaxes;
    @c(a = "deck")
    private String mDeck;
    @c(a = "passenger_id")
    private int mPassengerId;
    @c(a = "code")
    private String mSeatCode;
    @c(a = "seat_number")
    private String mSeatNumber;
    private double mSeatPrice;
    private String mTravellerFirstName;
    private String mTravellerLastName;
    private String mTravellerTitle;
    private String mTravellerType;

    public int describeContents() {
        return 0;
    }

    protected CJRSeatSelectedItem(Parcel parcel) {
        this.mTravellerTitle = parcel.readString();
        this.mTravellerFirstName = parcel.readString();
        this.mTravellerLastName = parcel.readString();
        this.mTravellerType = parcel.readString();
        this.mSeatCode = parcel.readString();
        this.mPassengerId = parcel.readInt();
        this.mSeatNumber = parcel.readString();
        this.mDeck = parcel.readString();
        this.mCJRSeatTaxes = new ArrayList();
        this.mCJRSeatTaxes = parcel.readArrayList(CJRSeatTax.class.getClassLoader());
        this.mSeatPrice = parcel.readDouble();
        this.isSeatSelected = parcel.readByte() != 0;
    }

    public CJRSeatSelectedItem() {
    }

    public double getmSeatPrice() {
        return this.mSeatPrice;
    }

    public void setmSeatPrice(double d2) {
        this.mSeatPrice = d2;
    }

    public List<CJRSeatTax> getmTax() {
        return this.mCJRSeatTaxes;
    }

    public void setmTax(List<CJRSeatTax> list) {
        this.mCJRSeatTaxes = list;
    }

    public String getmTravellerTitle() {
        return this.mTravellerTitle;
    }

    public void setmTravellerTitle(String str) {
        this.mTravellerTitle = str;
    }

    public String getmTravellerFirstName() {
        return this.mTravellerFirstName;
    }

    public void setmTravellerFirstName(String str) {
        this.mTravellerFirstName = str;
    }

    public String getmTravellerLastName() {
        return this.mTravellerLastName;
    }

    public void setmTravellerLastName(String str) {
        this.mTravellerLastName = str;
    }

    public String getmTravellerType() {
        return this.mTravellerType;
    }

    public void setmTravellerType(String str) {
        this.mTravellerType = str;
    }

    public String getmSeatCode() {
        return this.mSeatCode;
    }

    public void setmSeatCode(String str) {
        this.mSeatCode = str;
    }

    public int getmPassengerId() {
        return this.mPassengerId;
    }

    public void setmPassengerId(int i2) {
        this.mPassengerId = i2;
    }

    public String getmSeatNumber() {
        return this.mSeatNumber;
    }

    public void setmSeatNumber(String str) {
        this.mSeatNumber = str;
    }

    public String getmDeck() {
        return this.mDeck;
    }

    public void setmDeck(String str) {
        this.mDeck = str;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.mTravellerTitle);
        parcel.writeString(this.mTravellerFirstName);
        parcel.writeString(this.mTravellerLastName);
        parcel.writeString(this.mTravellerType);
        parcel.writeString(this.mSeatCode);
        parcel.writeInt(this.mPassengerId);
        parcel.writeString(this.mSeatNumber);
        parcel.writeString(this.mDeck);
        parcel.writeList(this.mCJRSeatTaxes);
        parcel.writeDouble(this.mSeatPrice);
        parcel.writeByte(this.isSeatSelected ? (byte) 1 : 0);
    }

    public boolean isSeatSelected() {
        return this.isSeatSelected;
    }

    public void setSeatSelected(boolean z) {
        this.isSeatSelected = z;
    }
}
