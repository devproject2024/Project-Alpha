package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;

public final class k implements Parcelable.Creator<LocationRequest> {
    public final /* synthetic */ Object[] newArray(int i2) {
        return new LocationRequest[i2];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int a2 = a.a(parcel);
        long j = 3600000;
        long j2 = 600000;
        long j3 = Long.MAX_VALUE;
        long j4 = 0;
        int i2 = 102;
        boolean z = false;
        int i3 = Integer.MAX_VALUE;
        float f2 = 0.0f;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    i2 = a.e(parcel2, readInt);
                    break;
                case 2:
                    j = a.g(parcel2, readInt);
                    break;
                case 3:
                    j2 = a.g(parcel2, readInt);
                    break;
                case 4:
                    z = a.c(parcel2, readInt);
                    break;
                case 5:
                    j3 = a.g(parcel2, readInt);
                    break;
                case 6:
                    i3 = a.e(parcel2, readInt);
                    break;
                case 7:
                    f2 = a.j(parcel2, readInt);
                    break;
                case 8:
                    j4 = a.g(parcel2, readInt);
                    break;
                default:
                    a.b(parcel2, readInt);
                    break;
            }
        }
        a.A(parcel2, a2);
        return new LocationRequest(i2, j, j2, z, j3, i3, f2, j4);
    }
}
