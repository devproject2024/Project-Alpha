package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import java.util.ArrayList;

public final class i implements Parcelable.Creator<AutocompleteFilter> {
    public final /* synthetic */ Object[] newArray(int i2) {
        return new AutocompleteFilter[i2];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a2 = a.a(parcel);
        int i2 = 0;
        ArrayList<Integer> arrayList = null;
        String str = null;
        boolean z = false;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            int i3 = 65535 & readInt;
            if (i3 == 1) {
                z = a.c(parcel, readInt);
            } else if (i3 == 2) {
                arrayList = a.w(parcel, readInt);
            } else if (i3 == 3) {
                str = a.n(parcel, readInt);
            } else if (i3 != 1000) {
                a.b(parcel, readInt);
            } else {
                i2 = a.e(parcel, readInt);
            }
        }
        a.A(parcel, a2);
        return new AutocompleteFilter(i2, z, arrayList, str);
    }
}
