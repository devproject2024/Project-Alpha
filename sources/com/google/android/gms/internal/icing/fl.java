package com.google.android.gms.internal.icing;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;

public final class fl implements Parcelable.Creator<zzk> {
    public final /* synthetic */ Object[] newArray(int i2) {
        return new zzk[i2];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a2 = a.a(parcel);
        String str = null;
        zzt zzt = null;
        byte[] bArr = null;
        int i2 = -1;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            int i3 = 65535 & readInt;
            if (i3 == 1) {
                str = a.n(parcel, readInt);
            } else if (i3 == 3) {
                zzt = (zzt) a.a(parcel, readInt, zzt.CREATOR);
            } else if (i3 == 4) {
                i2 = a.e(parcel, readInt);
            } else if (i3 != 5) {
                a.b(parcel, readInt);
            } else {
                bArr = a.q(parcel, readInt);
            }
        }
        a.A(parcel, a2);
        return new zzk(str, zzt, i2, bArr);
    }
}
