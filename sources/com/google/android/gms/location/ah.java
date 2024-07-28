package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.internal.location.zzbh;
import java.util.ArrayList;

public final class ah implements Parcelable.Creator<GeofencingRequest> {
    public final /* synthetic */ Object[] newArray(int i2) {
        return new GeofencingRequest[i2];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a2 = a.a(parcel);
        ArrayList<zzbh> arrayList = null;
        int i2 = 0;
        String str = "";
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            int i3 = 65535 & readInt;
            if (i3 == 1) {
                arrayList = a.c(parcel, readInt, zzbh.CREATOR);
            } else if (i3 == 2) {
                i2 = a.e(parcel, readInt);
            } else if (i3 != 3) {
                a.b(parcel, readInt);
            } else {
                str = a.n(parcel, readInt);
            }
        }
        a.A(parcel, a2);
        return new GeofencingRequest(arrayList, i2, str);
    }
}
