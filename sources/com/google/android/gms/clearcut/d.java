package com.google.android.gms.clearcut;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;

public final class d implements Parcelable.Creator<zzc> {
    public final /* synthetic */ Object[] newArray(int i2) {
        return new zzc[i2];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a2 = a.a(parcel);
        long j = 0;
        long j2 = 0;
        boolean z = false;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 1) {
                z = a.c(parcel, readInt);
            } else if (i2 == 2) {
                j2 = a.g(parcel, readInt);
            } else if (i2 != 3) {
                a.b(parcel, readInt);
            } else {
                j = a.g(parcel, readInt);
            }
        }
        a.A(parcel, a2);
        return new zzc(z, j, j2);
    }
}
