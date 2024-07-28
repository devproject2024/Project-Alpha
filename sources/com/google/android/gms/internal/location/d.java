package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.a;

public final class d implements Parcelable.Creator<zzad> {
    public final /* synthetic */ Object[] newArray(int i2) {
        return new zzad[i2];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a2 = a.a(parcel);
        Status status = null;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            if ((65535 & readInt) != 1) {
                a.b(parcel, readInt);
            } else {
                status = (Status) a.a(parcel, readInt, Status.CREATOR);
            }
        }
        a.A(parcel, a2);
        return new zzad(status);
    }
}
