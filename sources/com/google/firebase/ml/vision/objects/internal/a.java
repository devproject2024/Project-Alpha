package com.google.firebase.ml.vision.objects.internal;

import android.os.Parcel;
import android.os.Parcelable;

public final class a implements Parcelable.Creator<ObjectDetectorOptionsParcel> {
    public final /* synthetic */ Object[] newArray(int i2) {
        return new ObjectDetectorOptionsParcel[i2];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a2 = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        int i2 = 0;
        boolean z = false;
        boolean z2 = false;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            int i3 = 65535 & readInt;
            if (i3 == 1) {
                i2 = com.google.android.gms.common.internal.safeparcel.a.e(parcel, readInt);
            } else if (i3 == 2) {
                z = com.google.android.gms.common.internal.safeparcel.a.c(parcel, readInt);
            } else if (i3 != 3) {
                com.google.android.gms.common.internal.safeparcel.a.b(parcel, readInt);
            } else {
                z2 = com.google.android.gms.common.internal.safeparcel.a.c(parcel, readInt);
            }
        }
        com.google.android.gms.common.internal.safeparcel.a.A(parcel, a2);
        return new ObjectDetectorOptionsParcel(i2, z, z2);
    }
}
