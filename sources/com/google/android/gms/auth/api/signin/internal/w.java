package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.internal.safeparcel.a;

public final class w implements Parcelable.Creator<SignInConfiguration> {
    public final /* synthetic */ Object[] newArray(int i2) {
        return new SignInConfiguration[i2];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a2 = a.a(parcel);
        String str = null;
        GoogleSignInOptions googleSignInOptions = null;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 2) {
                str = a.n(parcel, readInt);
            } else if (i2 != 5) {
                a.b(parcel, readInt);
            } else {
                googleSignInOptions = (GoogleSignInOptions) a.a(parcel, readInt, GoogleSignInOptions.CREATOR);
            }
        }
        a.A(parcel, a2);
        return new SignInConfiguration(str, googleSignInOptions);
    }
}
