package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import java.util.ArrayList;

public final class j implements Parcelable.Creator<PlaceFilter> {
    public final /* synthetic */ Object[] newArray(int i2) {
        return new PlaceFilter[i2];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a2 = a.a(parcel);
        ArrayList<Integer> arrayList = null;
        boolean z = false;
        ArrayList<String> arrayList2 = null;
        ArrayList<zzp> arrayList3 = null;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 1) {
                arrayList = a.w(parcel, readInt);
            } else if (i2 == 6) {
                arrayList2 = a.x(parcel, readInt);
            } else if (i2 == 3) {
                z = a.c(parcel, readInt);
            } else if (i2 != 4) {
                a.b(parcel, readInt);
            } else {
                arrayList3 = a.c(parcel, readInt, zzp.CREATOR);
            }
        }
        a.A(parcel, a2);
        return new PlaceFilter(arrayList, z, arrayList2, arrayList3);
    }
}
