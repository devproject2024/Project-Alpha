package com.google.android.gms.location;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import java.util.ArrayList;

public final class t implements Parcelable.Creator<zzal> {
    public final /* synthetic */ Object[] newArray(int i2) {
        return new zzal[i2];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a2 = a.a(parcel);
        ArrayList<String> arrayList = null;
        String str = "";
        PendingIntent pendingIntent = null;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 1) {
                arrayList = a.x(parcel, readInt);
            } else if (i2 == 2) {
                pendingIntent = (PendingIntent) a.a(parcel, readInt, PendingIntent.CREATOR);
            } else if (i2 != 3) {
                a.b(parcel, readInt);
            } else {
                str = a.n(parcel, readInt);
            }
        }
        a.A(parcel, a2);
        return new zzal(arrayList, pendingIntent, str);
    }
}
