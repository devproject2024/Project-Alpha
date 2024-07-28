package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.safeparcel.a;

public final class ah implements Parcelable.Creator<ResolveAccountRequest> {
    public final /* synthetic */ Object[] newArray(int i2) {
        return new ResolveAccountRequest[i2];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int a2 = a.a(parcel);
        Account account = null;
        int i2 = 0;
        GoogleSignInAccount googleSignInAccount = null;
        int i3 = 0;
        while (parcel.dataPosition() < a2) {
            int readInt = parcel.readInt();
            int i4 = 65535 & readInt;
            if (i4 == 1) {
                i2 = a.e(parcel, readInt);
            } else if (i4 == 2) {
                account = (Account) a.a(parcel, readInt, Account.CREATOR);
            } else if (i4 == 3) {
                i3 = a.e(parcel, readInt);
            } else if (i4 != 4) {
                a.b(parcel, readInt);
            } else {
                googleSignInAccount = (GoogleSignInAccount) a.a(parcel, readInt, GoogleSignInAccount.CREATOR);
            }
        }
        a.A(parcel, a2);
        return new ResolveAccountRequest(i2, account, i3, googleSignInAccount);
    }
}
