package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import java.util.ArrayList;

public final class d implements Parcelable.Creator<zaj> {
    public final /* synthetic */ Object[] newArray(int i2) {
        return new zaj[i2];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a2 = a.a(parcel);
        ArrayList<zam> arrayList = null;
        int i2 = 0;
        String str = null;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            int i3 = 65535 & readInt;
            if (i3 == 1) {
                i2 = a.e(parcel, readInt);
            } else if (i3 == 2) {
                arrayList = a.c(parcel, readInt, zam.CREATOR);
            } else if (i3 != 3) {
                a.b(parcel, readInt);
            } else {
                str = a.n(parcel, readInt);
            }
        }
        a.A(parcel, a2);
        return new zaj(i2, arrayList, str);
    }
}
