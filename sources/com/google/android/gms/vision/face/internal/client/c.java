package com.google.android.gms.vision.face.internal.client;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;

public final class c implements Parcelable.Creator<zzf> {
    public final /* synthetic */ Object[] newArray(int i2) {
        return new zzf[i2];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a2 = a.a(parcel);
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        boolean z = false;
        boolean z2 = false;
        float f2 = -1.0f;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 2:
                    i2 = a.e(parcel, readInt);
                    break;
                case 3:
                    i3 = a.e(parcel, readInt);
                    break;
                case 4:
                    i4 = a.e(parcel, readInt);
                    break;
                case 5:
                    z = a.c(parcel, readInt);
                    break;
                case 6:
                    z2 = a.c(parcel, readInt);
                    break;
                case 7:
                    f2 = a.j(parcel, readInt);
                    break;
                default:
                    a.b(parcel, readInt);
                    break;
            }
        }
        a.A(parcel, a2);
        return new zzf(i2, i3, i4, z, z2, f2);
    }
}
