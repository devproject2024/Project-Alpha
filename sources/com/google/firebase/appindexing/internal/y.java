package com.google.firebase.appindexing.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.firebase.appindexing.internal.Thing;

public final class y implements Parcelable.Creator<Thing.zza> {
    public final /* synthetic */ Object[] newArray(int i2) {
        return new Thing.zza[i2];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a2 = a.a(parcel);
        boolean z = false;
        String str = null;
        Bundle bundle = null;
        int i2 = 0;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            int i3 = 65535 & readInt;
            if (i3 == 1) {
                z = a.c(parcel, readInt);
            } else if (i3 == 2) {
                i2 = a.e(parcel, readInt);
            } else if (i3 == 3) {
                str = a.n(parcel, readInt);
            } else if (i3 != 4) {
                a.b(parcel, readInt);
            } else {
                bundle = a.p(parcel, readInt);
            }
        }
        a.A(parcel, a2);
        return new Thing.zza(z, i2, str, bundle);
    }
}
