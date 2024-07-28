package com.google.android.gms.auth.api.identity;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.identity.BeginSignInRequest;
import com.google.android.gms.common.internal.safeparcel.a;

public final class d implements Parcelable.Creator<BeginSignInRequest.PasswordRequestOptions> {
    public final /* synthetic */ Object[] newArray(int i2) {
        return new BeginSignInRequest.PasswordRequestOptions[i2];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a2 = a.a(parcel);
        boolean z = false;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            if ((65535 & readInt) != 1) {
                a.b(parcel, readInt);
            } else {
                z = a.c(parcel, readInt);
            }
        }
        a.A(parcel, a2);
        return new BeginSignInRequest.PasswordRequestOptions(z);
    }
}
