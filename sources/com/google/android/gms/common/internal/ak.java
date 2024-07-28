package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;

final class ak implements Parcelable.Creator<BinderWrapper> {
    ak() {
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return new BinderWrapper[i2];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new BinderWrapper(parcel, (byte) 0);
    }
}
