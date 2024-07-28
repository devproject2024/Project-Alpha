package net.one97.paytm.wifi.models;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class WifiActivePlan implements Parcelable {
    public static final CREATOR CREATOR = new CREATOR((g) null);
    private String btnlabel;
    private String data;
    private String dataRemaining;
    private String dataUsed;
    private String downloadRate;
    private String duration;
    private String expiryTime;
    private String isActivePlan;
    private String isbtmsheetshow;
    private String planId;
    private String planName;
    private String price;
    private String type;
    private String uploadRate;

    public final int describeContents() {
        return 0;
    }

    public WifiActivePlan() {
    }

    public final String isActivePlan() {
        return this.isActivePlan;
    }

    public final void setActivePlan(String str) {
        this.isActivePlan = str;
    }

    public final String getType() {
        return this.type;
    }

    public final void setType(String str) {
        this.type = str;
    }

    public final String getPlanId() {
        return this.planId;
    }

    public final void setPlanId(String str) {
        this.planId = str;
    }

    public final String getDataUsed() {
        return this.dataUsed;
    }

    public final void setDataUsed(String str) {
        this.dataUsed = str;
    }

    public final String getDataRemaining() {
        return this.dataRemaining;
    }

    public final void setDataRemaining(String str) {
        this.dataRemaining = str;
    }

    public final String getExpiryTime() {
        return this.expiryTime;
    }

    public final void setExpiryTime(String str) {
        this.expiryTime = str;
    }

    public final String getPlanName() {
        return this.planName;
    }

    public final void setPlanName(String str) {
        this.planName = str;
    }

    public final String getData() {
        return this.data;
    }

    public final void setData(String str) {
        this.data = str;
    }

    public final String getDuration() {
        return this.duration;
    }

    public final void setDuration(String str) {
        this.duration = str;
    }

    public final String getPrice() {
        return this.price;
    }

    public final void setPrice(String str) {
        this.price = str;
    }

    public final String getDownloadRate() {
        return this.downloadRate;
    }

    public final void setDownloadRate(String str) {
        this.downloadRate = str;
    }

    public final String getUploadRate() {
        return this.uploadRate;
    }

    public final void setUploadRate(String str) {
        this.uploadRate = str;
    }

    public final String getIsbtmsheetshow() {
        return this.isbtmsheetshow;
    }

    public final void setIsbtmsheetshow(String str) {
        this.isbtmsheetshow = str;
    }

    public final String getBtnlabel() {
        return this.btnlabel;
    }

    public final void setBtnlabel(String str) {
        this.btnlabel = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public WifiActivePlan(Parcel parcel) {
        this();
        k.c(parcel, "parcel");
        this.isActivePlan = parcel.readString();
        this.type = parcel.readString();
        this.planId = parcel.readString();
        this.dataUsed = parcel.readString();
        this.dataRemaining = parcel.readString();
        this.expiryTime = parcel.readString();
        this.planName = parcel.readString();
        this.data = parcel.readString();
        this.duration = parcel.readString();
        this.price = parcel.readString();
        this.downloadRate = parcel.readString();
        this.uploadRate = parcel.readString();
        this.isbtmsheetshow = parcel.readString();
        this.btnlabel = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        k.c(parcel, "parcel");
        parcel.writeString(this.isActivePlan);
        parcel.writeString(this.type);
        parcel.writeString(this.planId);
        parcel.writeString(this.dataUsed);
        parcel.writeString(this.dataRemaining);
        parcel.writeString(this.expiryTime);
        parcel.writeString(this.planName);
        parcel.writeString(this.data);
        parcel.writeString(this.duration);
        parcel.writeString(this.price);
        parcel.writeString(this.downloadRate);
        parcel.writeString(this.uploadRate);
        parcel.writeString(this.isbtmsheetshow);
        parcel.writeString(this.btnlabel);
    }

    public static final class CREATOR implements Parcelable.Creator<WifiActivePlan> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(g gVar) {
            this();
        }

        public final WifiActivePlan createFromParcel(Parcel parcel) {
            k.c(parcel, "parcel");
            return new WifiActivePlan(parcel);
        }

        public final WifiActivePlan[] newArray(int i2) {
            return new WifiActivePlan[i2];
        }
    }
}
