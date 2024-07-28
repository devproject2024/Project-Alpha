package com.google.android.gms.safetynet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;

public final class zzh extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzh> CREATOR = new zzi();
    private final int zzk;
    private final boolean zzl;

    public zzh(int i2, boolean z) {
        this.zzk = i2;
        this.zzl = z;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.b(parcel, 2, this.zzk);
        b.a(parcel, 3, this.zzl);
        b.b(parcel, a2);
    }
}
