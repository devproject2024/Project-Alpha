package com.google.android.gms.internal.icing;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.a;
import java.util.ArrayList;

public final class fo implements Parcelable.Creator<zzo> {
    public final /* synthetic */ Object[] newArray(int i2) {
        return new zzo[i2];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a2 = a.a(parcel);
        Status status = null;
        ArrayList<zzw> arrayList = null;
        String[] strArr = null;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 1) {
                status = (Status) a.a(parcel, readInt, Status.CREATOR);
            } else if (i2 == 2) {
                arrayList = a.c(parcel, readInt, zzw.CREATOR);
            } else if (i2 != 3) {
                a.b(parcel, readInt);
            } else {
                strArr = a.v(parcel, readInt);
            }
        }
        a.A(parcel, a2);
        return new zzo(status, arrayList, strArr);
    }
}
