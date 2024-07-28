package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.safeparcel.a;

public final class al implements Parcelable.Creator<zzc> {
    public final /* synthetic */ Object[] newArray(int i2) {
        return new zzc[i2];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a2 = a.a(parcel);
        Bundle bundle = null;
        Feature[] featureArr = null;
        int i2 = 0;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            int i3 = 65535 & readInt;
            if (i3 == 1) {
                bundle = a.p(parcel, readInt);
            } else if (i3 == 2) {
                featureArr = (Feature[]) a.b(parcel, readInt, Feature.CREATOR);
            } else if (i3 != 3) {
                a.b(parcel, readInt);
            } else {
                i2 = a.e(parcel, readInt);
            }
        }
        a.A(parcel, a2);
        return new zzc(bundle, featureArr, i2);
    }
}
