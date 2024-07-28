package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import java.util.ArrayList;

public final class k implements Parcelable.Creator<zzc> {
    public final /* synthetic */ Object[] newArray(int i2) {
        return new zzc[i2];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a2 = a.a(parcel);
        String str = null;
        ArrayList<Integer> arrayList = null;
        String str2 = null;
        ArrayList<zzb> arrayList2 = null;
        String str3 = null;
        ArrayList<zzb> arrayList3 = null;
        String str4 = null;
        ArrayList<zzb> arrayList4 = null;
        int i2 = 0;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    str2 = a.n(parcel, readInt);
                    break;
                case 2:
                    str = a.n(parcel, readInt);
                    break;
                case 3:
                    arrayList = a.w(parcel, readInt);
                    break;
                case 4:
                    arrayList2 = a.c(parcel, readInt, zzb.CREATOR);
                    break;
                case 5:
                    i2 = a.e(parcel, readInt);
                    break;
                case 6:
                    str3 = a.n(parcel, readInt);
                    break;
                case 7:
                    arrayList3 = a.c(parcel, readInt, zzb.CREATOR);
                    break;
                case 8:
                    str4 = a.n(parcel, readInt);
                    break;
                case 9:
                    arrayList4 = a.c(parcel, readInt, zzb.CREATOR);
                    break;
                default:
                    a.b(parcel, readInt);
                    break;
            }
        }
        a.A(parcel, a2);
        return new zzc(str, arrayList, i2, str2, arrayList2, str3, arrayList3, str4, arrayList4);
    }
}
