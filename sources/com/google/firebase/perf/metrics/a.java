package com.google.firebase.perf.metrics;

import android.os.Parcel;
import android.os.Parcelable;

final class a implements Parcelable.Creator<zza> {
    a() {
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return new zza[i2];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new zza(parcel, (byte) 0);
    }
}
