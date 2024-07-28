package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;

public final class e implements Parcelable.Creator<CredentialPickerConfig> {
    public final /* synthetic */ Object[] newArray(int i2) {
        return new CredentialPickerConfig[i2];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a2 = a.a(parcel);
        int i2 = 0;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        int i3 = 0;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            int i4 = 65535 & readInt;
            if (i4 == 1) {
                z = a.c(parcel, readInt);
            } else if (i4 == 2) {
                z2 = a.c(parcel, readInt);
            } else if (i4 == 3) {
                z3 = a.c(parcel, readInt);
            } else if (i4 == 4) {
                i3 = a.e(parcel, readInt);
            } else if (i4 != 1000) {
                a.b(parcel, readInt);
            } else {
                i2 = a.e(parcel, readInt);
            }
        }
        a.A(parcel, a2);
        return new CredentialPickerConfig(i2, z, z2, z3, i3);
    }
}
