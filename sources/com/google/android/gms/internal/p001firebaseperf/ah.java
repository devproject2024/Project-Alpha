package com.google.android.gms.internal.p001firebaseperf;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: com.google.android.gms.internal.firebase-perf.ah  reason: invalid package */
final class ah implements Parcelable.Creator<zzbg> {
    ah() {
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return new zzbg[i2];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new zzbg(parcel, (byte) 0);
    }
}
