package com.google.android.gms.vision.face.internal.client;

import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;

public final class a implements Parcelable.Creator<zza> {
    public final /* synthetic */ Object[] newArray(int i2) {
        return new zza[i2];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a2 = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        PointF[] pointFArr = null;
        int i2 = 0;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            int i3 = 65535 & readInt;
            if (i3 == 2) {
                pointFArr = (PointF[]) com.google.android.gms.common.internal.safeparcel.a.b(parcel, readInt, PointF.CREATOR);
            } else if (i3 != 3) {
                com.google.android.gms.common.internal.safeparcel.a.b(parcel, readInt);
            } else {
                i2 = com.google.android.gms.common.internal.safeparcel.a.e(parcel, readInt);
            }
        }
        com.google.android.gms.common.internal.safeparcel.a.A(parcel, a2);
        return new zza(pointFArr, i2);
    }
}
