package com.google.android.gms.auth.api.identity;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.identity.BeginSignInRequest;

public final class a implements Parcelable.Creator<BeginSignInRequest> {
    public final /* synthetic */ Object[] newArray(int i2) {
        return new BeginSignInRequest[i2];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a2 = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        BeginSignInRequest.PasswordRequestOptions passwordRequestOptions = null;
        BeginSignInRequest.GoogleIdTokenRequestOptions googleIdTokenRequestOptions = null;
        String str = null;
        boolean z = false;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 1) {
                passwordRequestOptions = (BeginSignInRequest.PasswordRequestOptions) com.google.android.gms.common.internal.safeparcel.a.a(parcel, readInt, BeginSignInRequest.PasswordRequestOptions.CREATOR);
            } else if (i2 == 2) {
                googleIdTokenRequestOptions = (BeginSignInRequest.GoogleIdTokenRequestOptions) com.google.android.gms.common.internal.safeparcel.a.a(parcel, readInt, BeginSignInRequest.GoogleIdTokenRequestOptions.CREATOR);
            } else if (i2 == 3) {
                str = com.google.android.gms.common.internal.safeparcel.a.n(parcel, readInt);
            } else if (i2 != 4) {
                com.google.android.gms.common.internal.safeparcel.a.b(parcel, readInt);
            } else {
                z = com.google.android.gms.common.internal.safeparcel.a.c(parcel, readInt);
            }
        }
        com.google.android.gms.common.internal.safeparcel.a.A(parcel, a2);
        return new BeginSignInRequest(passwordRequestOptions, googleIdTokenRequestOptions, str, z);
    }
}
