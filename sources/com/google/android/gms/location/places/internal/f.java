package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import java.util.ArrayList;

public final class f implements Parcelable.Creator<zzal> {
    public final /* synthetic */ Object[] newArray(int i2) {
        return new zzal[i2];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a2 = a.a(parcel);
        ArrayList<zzao> arrayList = null;
        ArrayList<zzan> arrayList2 = null;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 1) {
                arrayList = a.c(parcel, readInt, zzao.CREATOR);
            } else if (i2 != 2) {
                a.b(parcel, readInt);
            } else {
                arrayList2 = a.c(parcel, readInt, zzan.CREATOR);
            }
        }
        a.A(parcel, a2);
        return new zzal(arrayList, arrayList2);
    }
}
