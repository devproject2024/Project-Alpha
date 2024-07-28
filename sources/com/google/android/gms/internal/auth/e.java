package com.google.android.gms.internal.auth;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;

public final class e implements Parcelable.Creator<zzah> {
    public final /* synthetic */ Object[] newArray(int i2) {
        return new zzah[i2];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a2 = a.a(parcel);
        String str = null;
        PendingIntent pendingIntent = null;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 1) {
                a.e(parcel, readInt);
            } else if (i2 == 2) {
                str = a.n(parcel, readInt);
            } else if (i2 != 3) {
                a.b(parcel, readInt);
            } else {
                pendingIntent = (PendingIntent) a.a(parcel, readInt, PendingIntent.CREATOR);
            }
        }
        a.A(parcel, a2);
        return new zzah(str, pendingIntent);
    }
}
