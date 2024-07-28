package net.one97.paytm.wifi.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class WifiPlan extends IJRPaytmDataModel implements Parcelable {
    public static final CREATOR CREATOR = new CREATOR((g) null);
    private String data;
    private long downloadRate;
    private String duration;
    private String planId;
    private String planName;
    private String price;
    private String type;
    private long uploadRate;

    public final int describeContents() {
        return 0;
    }

    public WifiPlan() {
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

    public final long getDownloadRate() {
        return this.downloadRate;
    }

    public final void setDownloadRate(long j) {
        this.downloadRate = j;
    }

    public final long getUploadRate() {
        return this.uploadRate;
    }

    public final void setUploadRate(long j) {
        this.uploadRate = j;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public WifiPlan(Parcel parcel) {
        this();
        k.c(parcel, "parcel");
        this.type = parcel.readString();
        this.planId = parcel.readString();
        this.planName = parcel.readString();
        this.data = parcel.readString();
        this.duration = parcel.readString();
        this.price = parcel.readString();
        this.downloadRate = parcel.readLong();
        this.uploadRate = parcel.readLong();
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        k.c(parcel, "parcel");
        parcel.writeString(this.type);
        parcel.writeString(this.planId);
        parcel.writeString(this.planName);
        parcel.writeString(this.data);
        parcel.writeString(this.duration);
        parcel.writeString(this.price);
        parcel.writeLong(this.downloadRate);
        parcel.writeLong(this.uploadRate);
    }

    public static final class CREATOR implements Parcelable.Creator<WifiPlan> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(g gVar) {
            this();
        }

        public final WifiPlan createFromParcel(Parcel parcel) {
            k.c(parcel, "parcel");
            return new WifiPlan(parcel);
        }

        public final WifiPlan[] newArray(int i2) {
            return new WifiPlan[i2];
        }
    }
}
