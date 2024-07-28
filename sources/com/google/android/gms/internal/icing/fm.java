package com.google.android.gms.internal.icing;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;

public final class fm implements Parcelable.Creator<zzm> {
    public final /* synthetic */ Object[] newArray(int i2) {
        return new zzm[i2];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a2 = a.a(parcel);
        int i2 = 0;
        Bundle bundle = null;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            int i3 = 65535 & readInt;
            if (i3 == 1) {
                i2 = a.e(parcel, readInt);
            } else if (i3 != 2) {
                a.b(parcel, readInt);
            } else {
                bundle = a.p(parcel, readInt);
            }
        }
        a.A(parcel, a2);
        return new zzm(i2, bundle);
    }
}
