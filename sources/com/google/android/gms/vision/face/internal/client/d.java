package com.google.android.gms.vision.face.internal.client;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;

public final class d implements Parcelable.Creator<LandmarkParcel> {
    public final /* synthetic */ Object[] newArray(int i2) {
        return new LandmarkParcel[i2];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a2 = a.a(parcel);
        float f2 = 0.0f;
        int i2 = 0;
        float f3 = 0.0f;
        int i3 = 0;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            int i4 = 65535 & readInt;
            if (i4 == 1) {
                i2 = a.e(parcel, readInt);
            } else if (i4 == 2) {
                f2 = a.j(parcel, readInt);
            } else if (i4 == 3) {
                f3 = a.j(parcel, readInt);
            } else if (i4 != 4) {
                a.b(parcel, readInt);
            } else {
                i3 = a.e(parcel, readInt);
            }
        }
        a.A(parcel, a2);
        return new LandmarkParcel(i2, f2, f3, i3);
    }
}
