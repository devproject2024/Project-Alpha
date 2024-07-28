package com.paytmmall.artifact.cart.entity;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;

public class CJRParcelTrackingInfo implements Parcelable {
    public static final Parcelable.Creator<CJRParcelTrackingInfo> CREATOR = new Parcelable.Creator<CJRParcelTrackingInfo>() {
        public final CJRParcelTrackingInfo createFromParcel(Parcel parcel) {
            return new CJRParcelTrackingInfo(parcel);
        }

        public final CJRParcelTrackingInfo[] newArray(int i2) {
            return new CJRParcelTrackingInfo[i2];
        }
    };
    @b(a = "cart_product_list")
    public ArrayList<CJRCartProduct> mCartProductList;
    @b(a = "order_id")
    public String mOrderId;

    public int describeContents() {
        return 0;
    }

    public CJRParcelTrackingInfo(Parcel parcel) {
        readFromParcel(parcel);
    }

    public CJRParcelTrackingInfo() {
    }

    public void setOrderId(String str) {
        this.mOrderId = str;
    }

    public void setCartItemsForTrackingInfo(ArrayList<CJRCartProduct> arrayList) {
        this.mCartProductList = arrayList;
    }

    public String getOrderId() {
        return this.mOrderId;
    }

    public ArrayList<CJRCartProduct> getCartItemsForTrackingInfo() {
        return this.mCartProductList;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.mOrderId);
        parcel.writeList(this.mCartProductList);
    }

    public void readFromParcel(Parcel parcel) {
        this.mOrderId = parcel.readString();
        this.mCartProductList = parcel.readArrayList((ClassLoader) null);
    }
}
