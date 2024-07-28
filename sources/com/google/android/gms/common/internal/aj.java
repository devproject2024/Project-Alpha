package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.a;

public final class aj implements Parcelable.Creator<SignInButtonConfig> {
    public final /* synthetic */ Object[] newArray(int i2) {
        return new SignInButtonConfig[i2];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a2 = a.a(parcel);
        int i2 = 0;
        Scope[] scopeArr = null;
        int i3 = 0;
        int i4 = 0;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            int i5 = 65535 & readInt;
            if (i5 == 1) {
                i2 = a.e(parcel, readInt);
            } else if (i5 == 2) {
                i3 = a.e(parcel, readInt);
            } else if (i5 == 3) {
                i4 = a.e(parcel, readInt);
            } else if (i5 != 4) {
                a.b(parcel, readInt);
            } else {
                scopeArr = (Scope[]) a.b(parcel, readInt, Scope.CREATOR);
            }
        }
        a.A(parcel, a2);
        return new SignInButtonConfig(i2, i3, i4, scopeArr);
    }
}
