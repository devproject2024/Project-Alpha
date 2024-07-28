package com.google.firebase.perf.internal;

import android.os.Parcel;
import android.os.Parcelable;

final class y implements Parcelable.Creator<zzs> {
    y() {
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return new zzs[i2];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new zzs(parcel, (byte) 0);
    }
}
