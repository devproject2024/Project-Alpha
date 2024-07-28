package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;

public final class jp implements Parcelable.Creator<zzkl> {
    public final /* synthetic */ Object[] newArray(int i2) {
        return new zzkl[i2];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int a2 = a.a(parcel);
        String str = null;
        Long l = null;
        Float f2 = null;
        String str2 = null;
        String str3 = null;
        Double d2 = null;
        long j = 0;
        int i2 = 0;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i2 = a.e(parcel2, readInt);
                    break;
                case 2:
                    str = a.n(parcel2, readInt);
                    break;
                case 3:
                    j = a.g(parcel2, readInt);
                    break;
                case 4:
                    l = a.h(parcel2, readInt);
                    break;
                case 5:
                    f2 = a.k(parcel2, readInt);
                    break;
                case 6:
                    str2 = a.n(parcel2, readInt);
                    break;
                case 7:
                    str3 = a.n(parcel2, readInt);
                    break;
                case 8:
                    int a3 = a.a(parcel2, readInt);
                    if (a3 != 0) {
                        a.b(parcel2, a3, 8);
                        d2 = Double.valueOf(parcel.readDouble());
                        break;
                    } else {
                        d2 = null;
                        break;
                    }
                default:
                    a.b(parcel2, readInt);
                    break;
            }
        }
        a.A(parcel2, a2);
        return new zzkl(i2, str, j, l, f2, str2, str3, d2);
    }
}
