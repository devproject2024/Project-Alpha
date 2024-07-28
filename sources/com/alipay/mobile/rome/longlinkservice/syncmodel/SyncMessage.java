package com.alipay.mobile.rome.longlinkservice.syncmodel;

import android.os.Parcel;
import android.os.Parcelable;

public class SyncMessage implements Parcelable {
    public static final Parcelable.Creator<SyncMessage> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public int f14979a;

    /* renamed from: b  reason: collision with root package name */
    public String f14980b;

    /* renamed from: c  reason: collision with root package name */
    public String f14981c;

    /* renamed from: d  reason: collision with root package name */
    public String f14982d;

    /* renamed from: e  reason: collision with root package name */
    public String f14983e;

    /* renamed from: f  reason: collision with root package name */
    public String f14984f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f14985g;

    public int describeContents() {
        return 0;
    }

    /* synthetic */ SyncMessage(Parcel parcel, byte b2) {
        this(parcel);
    }

    public SyncMessage() {
    }

    public String toString() {
        return "SyncMessage [userId=" + this.f14980b + ", biz=" + this.f14981c + ", msgData=" + this.f14982d + ", pushData=" + this.f14983e + ", id=" + this.f14984f + ", hasMore=" + this.f14985g + "], sOpcode=" + this.f14979a + "]";
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f14980b);
        parcel.writeString(this.f14981c);
        parcel.writeString(this.f14982d);
        parcel.writeString(this.f14983e);
        parcel.writeInt(this.f14979a);
        parcel.writeString(this.f14984f);
        if (this.f14985g) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
        }
    }

    private SyncMessage(Parcel parcel) {
        this.f14980b = parcel.readString();
        this.f14981c = parcel.readString();
        this.f14982d = parcel.readString();
        this.f14983e = parcel.readString();
        this.f14979a = parcel.readInt();
        this.f14984f = parcel.readString();
        if (parcel.readInt() == 0) {
            this.f14985g = false;
        } else {
            this.f14985g = true;
        }
    }
}
