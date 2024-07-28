package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;

public final class ac implements Parcelable.Creator<zzj> {
    public final /* synthetic */ Object[] newArray(int i2) {
        return new zzj[i2];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int a2 = a.a(parcel);
        long j = 50;
        long j2 = Long.MAX_VALUE;
        boolean z = true;
        float f2 = 0.0f;
        int i2 = Integer.MAX_VALUE;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            int i3 = 65535 & readInt;
            if (i3 == 1) {
                z = a.c(parcel2, readInt);
            } else if (i3 == 2) {
                j = a.g(parcel2, readInt);
            } else if (i3 == 3) {
                f2 = a.j(parcel2, readInt);
            } else if (i3 == 4) {
                j2 = a.g(parcel2, readInt);
            } else if (i3 != 5) {
                a.b(parcel2, readInt);
            } else {
                i2 = a.e(parcel2, readInt);
            }
        }
        a.A(parcel2, a2);
        return new zzj(z, j, f2, j2, i2);
    }
}
