package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;

public final class s implements Parcelable.Creator<Status> {
    public final /* synthetic */ Object[] newArray(int i2) {
        return new Status[i2];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a2 = a.a(parcel);
        int i2 = 0;
        String str = null;
        PendingIntent pendingIntent = null;
        int i3 = 0;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            int i4 = 65535 & readInt;
            if (i4 == 1) {
                i3 = a.e(parcel, readInt);
            } else if (i4 == 2) {
                str = a.n(parcel, readInt);
            } else if (i4 == 3) {
                pendingIntent = (PendingIntent) a.a(parcel, readInt, PendingIntent.CREATOR);
            } else if (i4 != 1000) {
                a.b(parcel, readInt);
            } else {
                i2 = a.e(parcel, readInt);
            }
        }
        a.A(parcel, a2);
        return new Status(i2, i3, str, pendingIntent);
    }
}
