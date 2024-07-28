package com.google.android.gms.cloudmessaging;

import android.os.Parcel;
import android.os.Parcelable;

final class c implements Parcelable.Creator<zza> {
    c() {
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return new zza[i2];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new zza(parcel.readStrongBinder());
    }
}
