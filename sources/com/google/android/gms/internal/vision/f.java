package com.google.android.gms.internal.vision;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;

public final class f implements Parcelable.Creator<zzah> {
    public final /* synthetic */ Object[] newArray(int i2) {
        return new zzah[i2];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a2 = a.a(parcel);
        while (parcel.dataPosition() < a2) {
            a.b(parcel, parcel.readInt());
        }
        a.A(parcel, a2);
        return new zzah();
    }
}
