package com.google.firebase.perf.metrics;

import android.os.Parcel;
import android.os.Parcelable;

final class b implements Parcelable.Creator<Trace> {
    b() {
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return new Trace[i2];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new Trace(parcel, false, (byte) 0);
    }
}
