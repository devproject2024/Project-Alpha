package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;

public final class y implements Parcelable.Creator<zzbh> {
    public final /* synthetic */ Object[] newArray(int i2) {
        return new zzbh[i2];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int a2 = a.a(parcel);
        double d2 = 0.0d;
        double d3 = 0.0d;
        String str = null;
        long j = 0;
        int i2 = 0;
        short s = 0;
        float f2 = 0.0f;
        int i3 = 0;
        int i4 = -1;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    str = a.n(parcel2, readInt);
                    break;
                case 2:
                    j = a.g(parcel2, readInt);
                    break;
                case 3:
                    a.a(parcel2, readInt, 4);
                    s = (short) parcel.readInt();
                    break;
                case 4:
                    d2 = a.l(parcel2, readInt);
                    break;
                case 5:
                    d3 = a.l(parcel2, readInt);
                    break;
                case 6:
                    f2 = a.j(parcel2, readInt);
                    break;
                case 7:
                    i2 = a.e(parcel2, readInt);
                    break;
                case 8:
                    i3 = a.e(parcel2, readInt);
                    break;
                case 9:
                    i4 = a.e(parcel2, readInt);
                    break;
                default:
                    a.b(parcel2, readInt);
                    break;
            }
        }
        a.A(parcel2, a2);
        return new zzbh(str, i2, s, d2, d3, f2, j, i3, i4);
    }
}
