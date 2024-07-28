package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;

public final class e implements Parcelable.Creator<DeviceMetaData> {
    public final /* synthetic */ Object[] newArray(int i2) {
        return new DeviceMetaData[i2];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a2 = a.a(parcel);
        long j = 0;
        int i2 = 0;
        boolean z = false;
        boolean z2 = false;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            int i3 = 65535 & readInt;
            if (i3 == 1) {
                i2 = a.e(parcel, readInt);
            } else if (i3 == 2) {
                z = a.c(parcel, readInt);
            } else if (i3 == 3) {
                j = a.g(parcel, readInt);
            } else if (i3 != 4) {
                a.b(parcel, readInt);
            } else {
                z2 = a.c(parcel, readInt);
            }
        }
        a.A(parcel, a2);
        return new DeviceMetaData(i2, z, j, z2);
    }
}
