package com.alipay.iap.android.common.syncintegration.api;

import android.os.Parcel;
import android.os.Parcelable;

public class IAPSyncMessage implements Parcelable {
    public static final Parcelable.Creator<IAPSyncMessage> CREATOR = new Parcelable.Creator<IAPSyncMessage>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
            return new IAPSyncMessage[i2];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new IAPSyncMessage(parcel);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public String f14703a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f14704b;

    /* renamed from: c  reason: collision with root package name */
    public String f14705c;

    /* renamed from: d  reason: collision with root package name */
    public String f14706d;

    /* renamed from: e  reason: collision with root package name */
    public String f14707e;

    public int describeContents() {
        return 0;
    }

    public IAPSyncMessage() {
    }

    protected IAPSyncMessage(Parcel parcel) {
        this.f14703a = parcel.readString();
        this.f14704b = parcel.readByte() != 0;
        this.f14705c = parcel.readString();
        this.f14706d = parcel.readString();
        this.f14707e = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f14703a);
        parcel.writeByte(this.f14704b ? (byte) 1 : 0);
        parcel.writeString(this.f14705c);
        parcel.writeString(this.f14706d);
        parcel.writeString(this.f14707e);
    }
}
