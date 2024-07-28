package com.google.android.gms.safetynet;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;

public final class zzd extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzd> CREATOR = new zze();
    public final long zzf;
    public final HarmfulAppsData[] zzg;
    public final int zzh;
    private final boolean zzi;

    public zzd(long j, HarmfulAppsData[] harmfulAppsDataArr, int i2, boolean z) {
        this.zzf = j;
        this.zzg = harmfulAppsDataArr;
        this.zzi = z;
        if (z) {
            this.zzh = i2;
        } else {
            this.zzh = -1;
        }
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.a(parcel, 2, this.zzf);
        b.a(parcel, 3, (T[]) this.zzg, i2);
        b.b(parcel, 4, this.zzh);
        b.a(parcel, 5, this.zzi);
        b.b(parcel, a2);
    }
}
