package com.alipay.mobile.rome.longlinkservice.syncmodel;

import android.os.Parcel;
import android.os.Parcelable;

final class a implements Parcelable.Creator<SyncMessage> {
    a() {
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
        return new SyncMessage[i2];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new SyncMessage(parcel, (byte) 0);
    }
}
