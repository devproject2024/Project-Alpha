package com.google.android.gms.internal.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;

public final class d implements Parcelable.Creator<zzaf> {
    public final /* synthetic */ Object[] newArray(int i2) {
        return new zzaf[i2];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a2 = a.a(parcel);
        String str = null;
        byte[] bArr = null;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 1) {
                a.e(parcel, readInt);
            } else if (i2 == 2) {
                str = a.n(parcel, readInt);
            } else if (i2 != 3) {
                a.b(parcel, readInt);
            } else {
                bArr = a.q(parcel, readInt);
            }
        }
        a.A(parcel, a2);
        return new zzaf(str, bArr);
    }
}
