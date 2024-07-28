package com.google.firebase.appindexing.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;

public final class x implements Parcelable.Creator<zzc> {
    public final /* synthetic */ Object[] newArray(int i2) {
        return new zzc[i2];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a2 = a.a(parcel);
        String str = null;
        String str2 = null;
        byte[] bArr = null;
        int i2 = 0;
        boolean z = false;
        boolean z2 = false;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i2 = a.e(parcel, readInt);
                    break;
                case 2:
                    z = a.c(parcel, readInt);
                    break;
                case 3:
                    str = a.n(parcel, readInt);
                    break;
                case 4:
                    str2 = a.n(parcel, readInt);
                    break;
                case 5:
                    bArr = a.q(parcel, readInt);
                    break;
                case 6:
                    z2 = a.c(parcel, readInt);
                    break;
                default:
                    a.b(parcel, readInt);
                    break;
            }
        }
        a.A(parcel, a2);
        return new zzc(i2, z, str, str2, bArr, z2);
    }
}
