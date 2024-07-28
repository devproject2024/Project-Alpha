package com.alipay.iap.android.common.syncintegration.api;

import android.os.Parcel;
import android.os.Parcelable;

public class IAPSyncCommand implements Parcelable {
    public static final Parcelable.Creator<IAPSyncCommand> CREATOR = new Parcelable.Creator<IAPSyncCommand>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
            return new IAPSyncCommand[i2];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new IAPSyncCommand(parcel);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public String f14698a;

    /* renamed from: b  reason: collision with root package name */
    public String f14699b;

    /* renamed from: c  reason: collision with root package name */
    public String f14700c;

    /* renamed from: d  reason: collision with root package name */
    public String f14701d;

    /* renamed from: e  reason: collision with root package name */
    public String f14702e;

    public int describeContents() {
        return 0;
    }

    public IAPSyncCommand() {
    }

    protected IAPSyncCommand(Parcel parcel) {
        this.f14698a = parcel.readString();
        this.f14699b = parcel.readString();
        this.f14700c = parcel.readString();
        this.f14701d = parcel.readString();
        this.f14702e = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f14698a);
        parcel.writeString(this.f14699b);
        parcel.writeString(this.f14700c);
        parcel.writeString(this.f14701d);
        parcel.writeString(this.f14702e);
    }
}
