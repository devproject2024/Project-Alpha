package com.google.android.gms.internal.places;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import java.util.ArrayList;

public final class c implements Parcelable.Creator<zzi> {
    public final /* synthetic */ Object[] newArray(int i2) {
        return new zzi[i2];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a2 = a.a(parcel);
        String str = null;
        String str2 = null;
        ArrayList<zzg> arrayList = null;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 1) {
                str = a.n(parcel, readInt);
            } else if (i2 == 2) {
                str2 = a.n(parcel, readInt);
            } else if (i2 != 6) {
                a.b(parcel, readInt);
            } else {
                arrayList = a.c(parcel, readInt, zzg.CREATOR);
            }
        }
        a.A(parcel, a2);
        return new zzi(str, str2, arrayList);
    }
}
