package com.google.firebase.ml.vision.automl.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;

public final class b implements Parcelable.Creator<zzl> {
    public final /* synthetic */ Object[] newArray(int i2) {
        return new zzl[i2];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a2 = a.a(parcel);
        String str = null;
        String str2 = null;
        float f2 = 0.0f;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 1) {
                str = a.n(parcel, readInt);
            } else if (i2 == 2) {
                str2 = a.n(parcel, readInt);
            } else if (i2 != 3) {
                a.b(parcel, readInt);
            } else {
                f2 = a.j(parcel, readInt);
            }
        }
        a.A(parcel, a2);
        return new zzl(str, str2, f2);
    }
}
