package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import java.util.ArrayList;
import java.util.List;

public final class jw implements Parcelable.Creator<zzm> {
    public final /* synthetic */ Object[] newArray(int i2) {
        return new zzm[i2];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int a2 = a.a(parcel);
        long j = 0;
        long j2 = 0;
        long j3 = 0;
        long j4 = 0;
        long j5 = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        Boolean bool = null;
        ArrayList<String> arrayList = null;
        String str8 = null;
        long j6 = -2147483648L;
        boolean z = true;
        boolean z2 = false;
        int i2 = 0;
        boolean z3 = true;
        boolean z4 = true;
        boolean z5 = false;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 2:
                    str = a.n(parcel2, readInt);
                    break;
                case 3:
                    str2 = a.n(parcel2, readInt);
                    break;
                case 4:
                    str3 = a.n(parcel2, readInt);
                    break;
                case 5:
                    str4 = a.n(parcel2, readInt);
                    break;
                case 6:
                    j = a.g(parcel2, readInt);
                    break;
                case 7:
                    j2 = a.g(parcel2, readInt);
                    break;
                case 8:
                    str5 = a.n(parcel2, readInt);
                    break;
                case 9:
                    z = a.c(parcel2, readInt);
                    break;
                case 10:
                    z2 = a.c(parcel2, readInt);
                    break;
                case 11:
                    j6 = a.g(parcel2, readInt);
                    break;
                case 12:
                    str6 = a.n(parcel2, readInt);
                    break;
                case 13:
                    j3 = a.g(parcel2, readInt);
                    break;
                case 14:
                    j4 = a.g(parcel2, readInt);
                    break;
                case 15:
                    i2 = a.e(parcel2, readInt);
                    break;
                case 16:
                    z3 = a.c(parcel2, readInt);
                    break;
                case 17:
                    z4 = a.c(parcel2, readInt);
                    break;
                case 18:
                    z5 = a.c(parcel2, readInt);
                    break;
                case 19:
                    str7 = a.n(parcel2, readInt);
                    break;
                case 21:
                    int a3 = a.a(parcel2, readInt);
                    if (a3 != 0) {
                        a.b(parcel2, a3, 4);
                        bool = Boolean.valueOf(parcel.readInt() != 0);
                        break;
                    } else {
                        bool = null;
                        break;
                    }
                case 22:
                    j5 = a.g(parcel2, readInt);
                    break;
                case 23:
                    arrayList = a.x(parcel2, readInt);
                    break;
                case 24:
                    str8 = a.n(parcel2, readInt);
                    break;
                default:
                    a.b(parcel2, readInt);
                    break;
            }
        }
        a.A(parcel2, a2);
        return new zzm(str, str2, str3, str4, j, j2, str5, z, z2, j6, str6, j3, j4, i2, z3, z4, z5, str7, bool, j5, (List<String>) arrayList, str8);
    }
}
