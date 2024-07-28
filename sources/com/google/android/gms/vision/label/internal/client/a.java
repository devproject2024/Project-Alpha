package com.google.android.gms.vision.label.internal.client;

import android.os.Parcel;
import android.os.Parcelable;

public final class a implements Parcelable.Creator<zzf> {
    public final /* synthetic */ Object[] newArray(int i2) {
        return new zzf[i2];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a2 = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        String str = null;
        String str2 = null;
        float f2 = 0.0f;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 2) {
                str2 = com.google.android.gms.common.internal.safeparcel.a.n(parcel, readInt);
            } else if (i2 == 3) {
                f2 = com.google.android.gms.common.internal.safeparcel.a.j(parcel, readInt);
            } else if (i2 != 4) {
                com.google.android.gms.common.internal.safeparcel.a.b(parcel, readInt);
            } else {
                str = com.google.android.gms.common.internal.safeparcel.a.n(parcel, readInt);
            }
        }
        com.google.android.gms.common.internal.safeparcel.a.A(parcel, a2);
        return new zzf(str, str2, f2);
    }
}
