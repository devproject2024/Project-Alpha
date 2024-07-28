package com.google.android.gms.auth.api.signin.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;

public final class c implements Parcelable.Creator<GoogleSignInOptionsExtensionParcelable> {
    public final /* synthetic */ Object[] newArray(int i2) {
        return new GoogleSignInOptionsExtensionParcelable[i2];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a2 = a.a(parcel);
        int i2 = 0;
        Bundle bundle = null;
        int i3 = 0;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            int i4 = 65535 & readInt;
            if (i4 == 1) {
                i2 = a.e(parcel, readInt);
            } else if (i4 == 2) {
                i3 = a.e(parcel, readInt);
            } else if (i4 != 3) {
                a.b(parcel, readInt);
            } else {
                bundle = a.p(parcel, readInt);
            }
        }
        a.A(parcel, a2);
        return new GoogleSignInOptionsExtensionParcelable(i2, i3, bundle);
    }
}
