package com.google.firebase.ml.vision.objects.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;

public final class b implements Parcelable.Creator<zzj> {
    public final /* synthetic */ Object[] newArray(int i2) {
        return new zzj[i2];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a2 = a.a(parcel);
        int[] iArr = null;
        Integer num = null;
        Float f2 = null;
        String str = null;
        int i2 = 0;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            int i3 = 65535 & readInt;
            if (i3 == 1) {
                iArr = a.s(parcel, readInt);
            } else if (i3 == 2) {
                num = a.f(parcel, readInt);
            } else if (i3 == 3) {
                f2 = a.k(parcel, readInt);
            } else if (i3 == 4) {
                str = a.n(parcel, readInt);
            } else if (i3 != 5) {
                a.b(parcel, readInt);
            } else {
                i2 = a.e(parcel, readInt);
            }
        }
        a.A(parcel, a2);
        return new zzj(iArr, num, f2, str, i2);
    }
}
