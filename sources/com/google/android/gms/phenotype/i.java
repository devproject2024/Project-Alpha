package com.google.android.gms.phenotype;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;

public final class i implements Parcelable.Creator<zzi> {
    public final /* synthetic */ Object[] newArray(int i2) {
        return new zzi[i2];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int a2 = a.a(parcel);
        String str = null;
        String str2 = null;
        byte[] bArr = null;
        long j = 0;
        double d2 = 0.0d;
        boolean z = false;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 2:
                    str = a.n(parcel2, readInt);
                    break;
                case 3:
                    j = a.g(parcel2, readInt);
                    break;
                case 4:
                    z = a.c(parcel2, readInt);
                    break;
                case 5:
                    d2 = a.l(parcel2, readInt);
                    break;
                case 6:
                    str2 = a.n(parcel2, readInt);
                    break;
                case 7:
                    bArr = a.q(parcel2, readInt);
                    break;
                case 8:
                    i2 = a.e(parcel2, readInt);
                    break;
                case 9:
                    i3 = a.e(parcel2, readInt);
                    break;
                default:
                    a.b(parcel2, readInt);
                    break;
            }
        }
        a.A(parcel2, a2);
        return new zzi(str, j, z, d2, str2, bArr, i2, i3);
    }
}
