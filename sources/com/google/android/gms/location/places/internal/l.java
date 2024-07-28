package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import java.util.ArrayList;

public final class l implements Parcelable.Creator<zzan> {
    public final /* synthetic */ Object[] newArray(int i2) {
        return new zzan[i2];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a2 = a.a(parcel);
        ArrayList<zzao> arrayList = null;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i2 = a.e(parcel, readInt);
                    break;
                case 2:
                    i3 = a.e(parcel, readInt);
                    break;
                case 3:
                    i4 = a.e(parcel, readInt);
                    break;
                case 4:
                    i5 = a.e(parcel, readInt);
                    break;
                case 5:
                    i6 = a.e(parcel, readInt);
                    break;
                case 6:
                    i7 = a.e(parcel, readInt);
                    break;
                case 7:
                    arrayList = a.c(parcel, readInt, zzao.CREATOR);
                    break;
                default:
                    a.b(parcel, readInt);
                    break;
            }
        }
        a.A(parcel, a2);
        return new zzan(i2, i3, i4, i5, i6, i7, arrayList);
    }
}
