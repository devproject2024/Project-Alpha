package com.google.android.gms.auth.api.signin;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.a;

public final class h implements Parcelable.Creator<SignInAccount> {
    public final /* synthetic */ Object[] newArray(int i2) {
        return new SignInAccount[i2];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a2 = a.a(parcel);
        String str = "";
        GoogleSignInAccount googleSignInAccount = null;
        String str2 = str;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            int i2 = 65535 & readInt;
            if (i2 == 4) {
                str = a.n(parcel, readInt);
            } else if (i2 == 7) {
                googleSignInAccount = (GoogleSignInAccount) a.a(parcel, readInt, GoogleSignInAccount.CREATOR);
            } else if (i2 != 8) {
                a.b(parcel, readInt);
            } else {
                str2 = a.n(parcel, readInt);
            }
        }
        a.A(parcel, a2);
        return new SignInAccount(str, googleSignInAccount, str2);
    }
}
