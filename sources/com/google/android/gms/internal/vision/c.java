package com.google.android.gms.internal.vision;

import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;

public final class c implements Parcelable.Creator<zzae> {
    public final /* synthetic */ Object[] newArray(int i2) {
        return new zzae[i2];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a2 = a.a(parcel);
        Rect rect = null;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            if ((65535 & readInt) != 2) {
                a.b(parcel, readInt);
            } else {
                rect = (Rect) a.a(parcel, readInt, Rect.CREATOR);
            }
        }
        a.A(parcel, a2);
        return new zzae(rect);
    }
}
